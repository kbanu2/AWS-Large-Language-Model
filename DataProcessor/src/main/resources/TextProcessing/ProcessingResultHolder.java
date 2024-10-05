package TextProcessing;

/**
 * Generated from IDL struct "ProcessingResult".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at Oct 5, 2024, 2:04:38 PM
 */

public final class ProcessingResultHolder
	implements org.omg.CORBA.portable.Streamable
{
	public TextProcessing.ProcessingResult value;

	public ProcessingResultHolder ()
	{
	}
	public ProcessingResultHolder(final TextProcessing.ProcessingResult initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return TextProcessing.ProcessingResultHelper.type ();
	}
	public void _read(final org.omg.CORBA.portable.InputStream _in)
	{
		value = TextProcessing.ProcessingResultHelper.read(_in);
	}
	public void _write(final org.omg.CORBA.portable.OutputStream _out)
	{
		TextProcessing.ProcessingResultHelper.write(_out, value);
	}
}
