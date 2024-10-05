package TextProcessing;

/**
 * Generated from IDL struct "WordFrequency".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at Oct 5, 2024, 2:04:38 PM
 */

public final class WordFrequencyHolder
	implements org.omg.CORBA.portable.Streamable
{
	public TextProcessing.WordFrequency value;

	public WordFrequencyHolder ()
	{
	}
	public WordFrequencyHolder(final TextProcessing.WordFrequency initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return TextProcessing.WordFrequencyHelper.type ();
	}
	public void _read(final org.omg.CORBA.portable.InputStream _in)
	{
		value = TextProcessing.WordFrequencyHelper.read(_in);
	}
	public void _write(final org.omg.CORBA.portable.OutputStream _out)
	{
		TextProcessing.WordFrequencyHelper.write(_out, value);
	}
}
