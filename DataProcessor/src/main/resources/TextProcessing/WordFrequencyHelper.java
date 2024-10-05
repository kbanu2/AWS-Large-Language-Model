package TextProcessing;


/**
 * Generated from IDL struct "WordFrequency".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at Oct 5, 2024, 2:04:38 PM
 */

public abstract class WordFrequencyHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(WordFrequencyHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_struct_tc(TextProcessing.WordFrequencyHelper.id(),"WordFrequency",new org.omg.CORBA.StructMember[]{new org.omg.CORBA.StructMember("word", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("frequency", org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(3)), null)});
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final TextProcessing.WordFrequency s)
	{
		any.type(type());
		write( any.create_output_stream(),s);
	}

	public static TextProcessing.WordFrequency extract (final org.omg.CORBA.Any any)
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
		return "IDL:TextProcessing/WordFrequency:1.0";
	}
	public static TextProcessing.WordFrequency read (final org.omg.CORBA.portable.InputStream in)
	{
		TextProcessing.WordFrequency result = new TextProcessing.WordFrequency();
		result.word=in.read_string();
		result.frequency=in.read_long();
		return result;
	}
	public static void write (final org.omg.CORBA.portable.OutputStream out, final TextProcessing.WordFrequency s)
	{
		java.lang.String tmpResult1 = s.word;
out.write_string( tmpResult1 );
		out.write_long(s.frequency);
	}
}
