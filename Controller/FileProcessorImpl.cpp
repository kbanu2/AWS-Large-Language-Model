#include "TextProcessing.hh" // Generated from IDL
#include <omniORB4/CORBA.h>
#include <iostream>

class FileProcessorImpl : public POA_TextProcessing::FileProcessor {
public:
    FileProcessorImpl(CORBA::ORB_ptr orb) : orb_(CORBA::ORB::_duplicate(orb)) {}

    TextProcessing::ProcessingResult* processChunk(const char* chunkContent) override {
        // Create a new Scala FileProcessor for each chunk processing task
        CORBA::Object_var obj = orb_->string_to_object("corbaloc::localhost:1050/ScalaFileProcessorFactory");
        TextProcessing::FileProcessor_var scalaProcessor = TextProcessing::FileProcessor::_narrow(obj);

        return scalaProcessor->processChunk(chunkContent);
    }

    void writeResults(const TextProcessing::ProcessingResult& results) override {}

private:
    CORBA::ORB_var orb_;
};
