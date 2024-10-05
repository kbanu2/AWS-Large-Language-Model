package TextProcessing;


/**
 * Generated from IDL interface "Controller".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at Oct 5, 2024, 2:04:38 PM
 */

public abstract class ControllerPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, TextProcessing.ControllerOperations
{
	static private final java.util.HashMap<String,Integer> m_opsHash = new java.util.HashMap<String,Integer>();
	static
	{
		m_opsHash.put ( "startProcessing", Integer.valueOf(0));
		m_opsHash.put ( "finishProcessing", Integer.valueOf(1));
	}
	private String[] ids = {"IDL:TextProcessing/Controller:1.0"};
	public TextProcessing.Controller _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		TextProcessing.Controller __r = TextProcessing.ControllerHelper.narrow(__o);
		return __r;
	}
	public TextProcessing.Controller _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		TextProcessing.Controller __r = TextProcessing.ControllerHelper.narrow(__o);
		return __r;
	}
	public org.omg.CORBA.portable.OutputStream _invoke(String method, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.ResponseHandler handler)
		throws org.omg.CORBA.SystemException
	{
		org.omg.CORBA.portable.OutputStream _out = null;
		// do something
		// quick lookup of operation
		java.lang.Integer opsIndex = (java.lang.Integer)m_opsHash.get ( method );
		if ( null == opsIndex )
			throw new org.omg.CORBA.BAD_OPERATION(method + " not found");
		switch ( opsIndex.intValue() )
		{
			case 0: // startProcessing
			{
				java.lang.String _arg0=_input.read_string();
				_out = handler.createReply();
				startProcessing(_arg0);
				break;
			}
			case 1: // finishProcessing
			{
				_out = handler.createReply();
				finishProcessing();
				break;
			}
		}
		return _out;
	}

	public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte[] obj_id)
	{
		return ids;
	}
}
