import org.omg.CORBA._
import org.omg.PortableServer._
import TextProcessing._
import org.omg.CosNaming.{NameComponent, NamingContextHelper}

object Main extends App {
  val orb = ORB.init(args, null)

  // Create and register the POA
  val poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"))
  poa.the_POAManager.activate()

  // Create an instance of your servant
  val fileProcessor = new FileProcessorImpl() // Implement this class
  val fileProcessorId = poa.activate_object(fileProcessor)

  // Get the object reference
  val fileProcessorRef = poa.servant_to_reference(fileProcessor)

  // Convert the reference to IOR string
  val ior = orb.object_to_string(fileProcessorRef)
  println(s"IOR: $ior") // Output the IOR string


  // Start listening for incoming requests
  println("Server is running...")
  orb.run()
}
