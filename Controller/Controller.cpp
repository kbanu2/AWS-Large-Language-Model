#include "TextProcessing.hh" // Generated from IDL
#include <omniORB4/CORBA.h>
#include <fstream>
#include <vector>
#include <iostream>
using namespace std;

const size_t CHUNK_SIZE = 8192;

class ControllerImpl : public POA_TextProcessing::Controller {
public:
    ControllerImpl(CORBA::ORB_ptr orb, PortableServer::POA_ptr poa)
            : orb_(CORBA::ORB::_duplicate(orb)), poa_(PortableServer::POA::_duplicate(poa)) {}

    void startProcessing(const char* filename) {
        std::cout << "Client connected and requested to process file: " << filename << std::endl;
        std::vector<std::string> chunks = divideFileIntoChunks(filename, CHUNK_SIZE);

        // Create a Scala FileProcessor
        CORBA::Object_var obj = orb_->string_to_object("corbaloc::localhost:127.0.0.1:5050/FileProcessor");
        TextProcessing::FileProcessor_var scalaProcessor = TextProcessing::FileProcessor::_narrow(obj);

        if (CORBA::is_nil(scalaProcessor)) {
            std::cerr << "Failed to connect to Scala FileProcessor" << std::endl;
            return;
        }

        // Process the first chunk (consider looping over all chunks if needed)
        TextProcessing::ProcessingResult_var result = scalaProcessor->processChunk(chunks[0].c_str());

//        if (CORBA::is_nil(result)) {
//            std::cerr << "Processing failed or returned nil result" << std::endl;
//            return;
//        }

        int n = result->vectorEmbedding.length();
        if (n > 0) {
            int m = result->vectorEmbedding[0].length(); // Only valid if n > 0
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    std::cout << result->vectorEmbedding[i][j] << std::endl;
                }
            }
        } else {
            std::cout << "No embeddings returned." << std::endl;
        }
    }

    void finishProcessing() {
        orb_->shutdown(false);
    }

private:
    CORBA::ORB_var orb_;
    PortableServer::POA_var poa_;

    std::vector<std::string> divideFileIntoChunks(std::string fileName, size_t chunkSize);
};

int main(int argc, char** argv) {
    try {
        // Initialize ORB with correct arguments
        char* args[] = { "127.0.0.1", "1050" };
        int arg_count = sizeof(args) / sizeof(args[0]);

        std::cout << "Initializing ORB..." << std::endl;

        // Initialize the ORB
        CORBA::ORB_var orb = CORBA::ORB_init(arg_count, args);
        std::cout << "ORB initialized." << std::endl;

        // Retrieve the Root POA and activate the ControllerImpl
        PortableServer::POA_var poa = PortableServer::POA::_narrow(orb->resolve_initial_references("RootPOA"));
        PortableServer::ObjectId_var id = poa->activate_object(new ControllerImpl(orb, poa));
        CORBA::Object_var obj = poa->id_to_reference(id);

        // Convert IOR string to object reference
        const char* ior = "IOR:000000000000002549444C3A5465787450726F63657373696E672F46696C6550726F636573736F723A312E30000000000000000100000000000000B8000102000000000D3139322E3136382E312E36320000D6760000001F373134313030323431312F000B35373937101947100630463814141B484C1B000000000300000003000000320000000000000028666434663A653432663A373430353A346534333A313834343A623638303A363762623A6532313700D67600000000000000000008000000004A4143000000000100000024000000000501000100000002000100010001000F00010109000000020501000100010100"; // Update with your actual IOR
        CORBA::Object_var fileProcessorObj = orb->string_to_object(ior);

        // Narrow to FileProcessor interface
        TextProcessing::FileProcessor_var fileProcessor = TextProcessing::FileProcessor::_narrow(fileProcessorObj);

        if (CORBA::is_nil(fileProcessor)) {
            std::cerr << "Failed to narrow to FileProcessor." << std::endl;
            return 1;
        }

        std::cout << "Successfully narrowed to FileProcessor." << std::endl;

        // Use the FileProcessor to process a chunk
        std::string chunk = "Sample text to process";  // Replace with actual content
        fileProcessor->processChunk(chunk.c_str());

        // Clean up and shutdown
        orb->shutdown(false);
    } catch (const CORBA::Exception& ex) {
        std::cerr << "CORBA Exception: " << ex._name() << " - " << ex._rep_id() << std::endl;
        return 1;
    } catch (const std::exception& ex) {
        std::cerr << "Standard Exception: " << ex.what() << std::endl;
        return 1;
    }

    std::cout << "Exiting..." << std::endl;
    return 0;
}

std::vector<std::string> ControllerImpl::divideFileIntoChunks(std::string fileName, size_t chunkSize){
    std::ifstream file(fileName);
    std::vector<std::string> chunks;

    if (!file.is_open()) {
        std::cout << "file ERROR" << std::endl;
        return chunks;
    }

    std::string buffer;
    buffer.reserve(chunkSize);  // Preallocate space for performance

    char ch;
    while (file.get(ch)) {
        buffer += ch;
        if (buffer.size() >= chunkSize) {
            chunks.push_back(buffer);
            buffer.clear();
            buffer.reserve(chunkSize);
        }
    }

    // Push the last chunk if any
    if (!buffer.empty()) {
        chunks.push_back(buffer);
    }

    file.close();
    std::cout << "file read" << std::endl;
    return chunks;
}