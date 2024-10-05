package TextProcessing;

/**
 * Generated from IDL alias "WordMapList".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at Oct 5, 2024, 2:04:38 PM
 */

public final class WordMapListHolder
	implements org.omg.CORBA.portable.Streamable
{
	public TextProcessing.WordMap[] value;

	public WordMapListHolder ()
	{
	}
	public WordMapListHolder (final TextProcessing.WordMap[] initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return WordMapListHelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = WordMapListHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream out)
	{
		WordMapListHelper.write (out,value);
	}
}
