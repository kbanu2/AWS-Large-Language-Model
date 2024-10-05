package TextProcessing;

/**
 * Generated from IDL interface "Controller".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at Oct 5, 2024, 2:04:38 PM
 */

public final class ControllerHolder	implements org.omg.CORBA.portable.Streamable{
	 public Controller value;
	public ControllerHolder()
	{
	}
	public ControllerHolder (final Controller initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return ControllerHelper.type();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = ControllerHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		ControllerHelper.write (_out,value);
	}
}
