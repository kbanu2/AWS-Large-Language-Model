package TextProcessing;


/**
 * Generated from IDL interface "FileProcessor".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at Oct 5, 2024, 2:04:38 PM
 */

public abstract class FileProcessorHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(FileProcessorHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_interface_tc("IDL:TextProcessing/FileProcessor:1.0", "FileProcessor");
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final TextProcessing.FileProcessor s)
	{
			any.insert_Object(s);
	}
	public static TextProcessing.FileProcessor extract(final org.omg.CORBA.Any any)
	{
		return narrow(any.extract_Object()) ;
	}
	public static String id()
	{
		return "IDL:TextProcessing/FileProcessor:1.0";
	}
	public static FileProcessor read(final org.omg.CORBA.portable.InputStream in)
	{
		return narrow(in.read_Object(TextProcessing._FileProcessorStub.class));
	}
	public static void write(final org.omg.CORBA.portable.OutputStream _out, final TextProcessing.FileProcessor s)
	{
		_out.write_Object(s);
	}
	public static TextProcessing.FileProcessor narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof TextProcessing.FileProcessor)
		{
			return (TextProcessing.FileProcessor)obj;
		}
		else if (obj._is_a("IDL:TextProcessing/FileProcessor:1.0"))
		{
			TextProcessing._FileProcessorStub stub;
			stub = new TextProcessing._FileProcessorStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
		else
		{
			throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
		}
	}
	public static TextProcessing.FileProcessor unchecked_narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof TextProcessing.FileProcessor)
		{
			return (TextProcessing.FileProcessor)obj;
		}
		else
		{
			TextProcessing._FileProcessorStub stub;
			stub = new TextProcessing._FileProcessorStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
	}
}
