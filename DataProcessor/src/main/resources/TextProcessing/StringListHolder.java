package TextProcessing;

/**
 * Generated from IDL alias "StringList".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at Oct 5, 2024, 2:04:38 PM
 */

public final class StringListHolder
	implements org.omg.CORBA.portable.Streamable
{
	public java.lang.String[] value;

	public StringListHolder ()
	{
	}
	public StringListHolder (final java.lang.String[] initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return StringListHelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = StringListHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream out)
	{
		StringListHelper.write (out,value);
	}
}
