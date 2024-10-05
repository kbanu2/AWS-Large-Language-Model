package TextProcessing;

/**
 * Generated from IDL alias "DoubleList".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at Oct 5, 2024, 2:04:38 PM
 */

public final class DoubleListHolder
	implements org.omg.CORBA.portable.Streamable
{
	public double[] value;

	public DoubleListHolder ()
	{
	}
	public DoubleListHolder (final double[] initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return DoubleListHelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = DoubleListHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream out)
	{
		DoubleListHelper.write (out,value);
	}
}
