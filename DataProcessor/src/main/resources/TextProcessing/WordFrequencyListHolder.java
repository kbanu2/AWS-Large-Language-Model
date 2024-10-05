package TextProcessing;

/**
 * Generated from IDL alias "WordFrequencyList".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at Oct 5, 2024, 2:04:38 PM
 */

public final class WordFrequencyListHolder
	implements org.omg.CORBA.portable.Streamable
{
	public TextProcessing.WordFrequency[] value;

	public WordFrequencyListHolder ()
	{
	}
	public WordFrequencyListHolder (final TextProcessing.WordFrequency[] initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return WordFrequencyListHelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = WordFrequencyListHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream out)
	{
		WordFrequencyListHelper.write (out,value);
	}
}
