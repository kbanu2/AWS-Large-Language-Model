package TextProcessing;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "Controller".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at Oct 5, 2024, 2:04:38 PM
 */

public class ControllerPOATie
	extends ControllerPOA
{
	private ControllerOperations _delegate;

	private POA _poa;
	public ControllerPOATie(ControllerOperations delegate)
	{
		_delegate = delegate;
	}
	public ControllerPOATie(ControllerOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
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
	public ControllerOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(ControllerOperations delegate)
	{
		_delegate = delegate;
	}
	public POA _default_POA()
	{
		if (_poa != null)
		{
			return _poa;
		}
		return super._default_POA();
	}
	public void startProcessing(java.lang.String filename)
	{
_delegate.startProcessing(filename);
	}

	public void finishProcessing()
	{
_delegate.finishProcessing();
	}

}
