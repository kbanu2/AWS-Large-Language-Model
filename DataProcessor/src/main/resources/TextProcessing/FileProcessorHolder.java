package TextProcessing;

/**
 * Generated from IDL interface "FileProcessor".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at Oct 5, 2024, 2:04:38 PM
 */

public final class FileProcessorHolder	implements org.omg.CORBA.portable.Streamable{
	 public FileProcessor value;
	public FileProcessorHolder()
	{
	}
	public FileProcessorHolder (final FileProcessor initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return FileProcessorHelper.type();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = FileProcessorHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		FileProcessorHelper.write (_out,value);
	}
}
