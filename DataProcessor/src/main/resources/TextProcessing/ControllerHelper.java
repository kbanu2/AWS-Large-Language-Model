package TextProcessing;


/**
 * Generated from IDL interface "Controller".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at Oct 5, 2024, 2:04:38 PM
 */

public abstract class ControllerHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(ControllerHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_interface_tc("IDL:TextProcessing/Controller:1.0", "Controller");
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final TextProcessing.Controller s)
	{
			any.insert_Object(s);
	}
	public static TextProcessing.Controller extract(final org.omg.CORBA.Any any)
	{
		return narrow(any.extract_Object()) ;
	}
	public static String id()
	{
		return "IDL:TextProcessing/Controller:1.0";
	}
	public static Controller read(final org.omg.CORBA.portable.InputStream in)
	{
		return narrow(in.read_Object(TextProcessing._ControllerStub.class));
	}
	public static void write(final org.omg.CORBA.portable.OutputStream _out, final TextProcessing.Controller s)
	{
		_out.write_Object(s);
	}
	public static TextProcessing.Controller narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof TextProcessing.Controller)
		{
			return (TextProcessing.Controller)obj;
		}
		else if (obj._is_a("IDL:TextProcessing/Controller:1.0"))
		{
			TextProcessing._ControllerStub stub;
			stub = new TextProcessing._ControllerStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
		else
		{
			throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
		}
	}
	public static TextProcessing.Controller unchecked_narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof TextProcessing.Controller)
		{
			return (TextProcessing.Controller)obj;
		}
		else
		{
			TextProcessing._ControllerStub stub;
			stub = new TextProcessing._ControllerStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
	}
}
