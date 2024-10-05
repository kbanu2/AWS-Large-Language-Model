package TextProcessing;

/**
 * Generated from IDL struct "WordMap".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at Oct 5, 2024, 2:04:38 PM
 */

public final class WordMapHolder
	implements org.omg.CORBA.portable.Streamable
{
	public TextProcessing.WordMap value;

	public WordMapHolder ()
	{
	}
	public WordMapHolder(final TextProcessing.WordMap initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return TextProcessing.WordMapHelper.type ();
	}
	public void _read(final org.omg.CORBA.portable.InputStream _in)
	{
		value = TextProcessing.WordMapHelper.read(_in);
	}
	public void _write(final org.omg.CORBA.portable.OutputStream _out)
	{
		TextProcessing.WordMapHelper.write(_out, value);
	}
}
