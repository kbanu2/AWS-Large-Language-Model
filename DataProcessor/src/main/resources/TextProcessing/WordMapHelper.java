package TextProcessing;


/**
 * Generated from IDL struct "WordMap".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at Oct 5, 2024, 2:04:38 PM
 */

public abstract class WordMapHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(WordMapHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_struct_tc(TextProcessing.WordMapHelper.id(),"WordMap",new org.omg.CORBA.StructMember[]{new org.omg.CORBA.StructMember("word", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("uid", org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(3)), null)});
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final TextProcessing.WordMap s)
	{
		any.type(type());
		write( any.create_output_stream(),s);
	}

	public static TextProcessing.WordMap extract (final org.omg.CORBA.Any any)
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
		return "IDL:TextProcessing/WordMap:1.0";
	}
	public static TextProcessing.WordMap read (final org.omg.CORBA.portable.InputStream in)
	{
		TextProcessing.WordMap result = new TextProcessing.WordMap();
		result.word=in.read_string();
		result.uid=in.read_long();
		return result;
	}
	public static void write (final org.omg.CORBA.portable.OutputStream out, final TextProcessing.WordMap s)
	{
		java.lang.String tmpResult2 = s.word;
out.write_string( tmpResult2 );
		out.write_long(s.uid);
	}
}
