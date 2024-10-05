package TextProcessing;


/**
 * Generated from IDL struct "ProcessingResult".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at Oct 5, 2024, 2:04:38 PM
 */

public abstract class ProcessingResultHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(ProcessingResultHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_struct_tc(TextProcessing.ProcessingResultHelper.id(),"ProcessingResult",new org.omg.CORBA.StructMember[]{new org.omg.CORBA.StructMember("wordFrequencies", org.omg.CORBA.ORB.init().create_alias_tc(TextProcessing.WordFrequencyListHelper.id(), "WordFrequencyList",org.omg.CORBA.ORB.init().create_sequence_tc(0, org.omg.CORBA.ORB.init().create_struct_tc(TextProcessing.WordFrequencyHelper.id(),"WordFrequency",new org.omg.CORBA.StructMember[]{new org.omg.CORBA.StructMember("word", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("frequency", org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(3)), null)}))), null),new org.omg.CORBA.StructMember("wordMappings", org.omg.CORBA.ORB.init().create_alias_tc(TextProcessing.WordMapListHelper.id(), "WordMapList",org.omg.CORBA.ORB.init().create_sequence_tc(0, org.omg.CORBA.ORB.init().create_struct_tc(TextProcessing.WordMapHelper.id(),"WordMap",new org.omg.CORBA.StructMember[]{new org.omg.CORBA.StructMember("word", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("uid", org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(3)), null)}))), null),new org.omg.CORBA.StructMember("vectorEmbedding", org.omg.CORBA.ORB.init().create_alias_tc(TextProcessing.DoubleListHelper.id(), "DoubleList",org.omg.CORBA.ORB.init().create_sequence_tc(0, org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(7)))), null)});
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final TextProcessing.ProcessingResult s)
	{
		any.type(type());
		write( any.create_output_stream(),s);
	}

	public static TextProcessing.ProcessingResult extract (final org.omg.CORBA.Any any)
	{
		org.omg.CORBA.portable.InputStream in = any.create_input_stream();
		try
		{
			return read (in);
		}
		finally
		{
			try
			{
				in.close();
			}
			catch (java.io.IOException e)
			{
			throw new RuntimeException("Unexpected exception " + e.toString() );
			}
		}
	}

	public static String id()
	{
		return "IDL:TextProcessing/ProcessingResult:1.0";
	}
	public static TextProcessing.ProcessingResult read (final org.omg.CORBA.portable.InputStream in)
	{
		TextProcessing.ProcessingResult result = new TextProcessing.ProcessingResult();
		result.wordFrequencies = TextProcessing.WordFrequencyListHelper.read(in);
		result.wordMappings = TextProcessing.WordMapListHelper.read(in);
		result.vectorEmbedding = TextProcessing.DoubleListHelper.read(in);
		return result;
	}
	public static void write (final org.omg.CORBA.portable.OutputStream out, final TextProcessing.ProcessingResult s)
	{
		TextProcessing.WordFrequencyListHelper.write(out,s.wordFrequencies);
		TextProcessing.WordMapListHelper.write(out,s.wordMappings);
		TextProcessing.DoubleListHelper.write(out,s.vectorEmbedding);
	}
}
