package TextProcessing;

/**
 * Generated from IDL alias "DoubleList".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at Oct 5, 2024, 2:04:38 PM
 */

public abstract class DoubleListHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;

	public static void insert (org.omg.CORBA.Any any, double[] s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static double[] extract (final org.omg.CORBA.Any any)
	{
		if ( any.type().kind() == org.omg.CORBA.TCKind.tk_null)
		{
			throw new org.omg.CORBA.BAD_OPERATION ("Can't extract from Any with null type.");
		}
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(DoubleListHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_alias_tc(TextProcessing.DoubleListHelper.id(), "DoubleList",org.omg.CORBA.ORB.init().create_sequence_tc(0, org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(7))));
				}
			}
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:TextProcessing/DoubleList:1.0";
	}
	public static double[] read (final org.omg.CORBA.portable.InputStream _in)
	{
		double[] _result;
		int _l_result1 = _in.read_long();
		try
		{
			 int x = _in.available();
			 if ( x > 0 && _l_result1 > x )
				{
					throw new org.omg.CORBA.MARSHAL("Sequence length too large. Only " + x + " available and trying to assign " + _l_result1);
				}
		}
		catch (java.io.IOException e)
		{
		}
		_result = new double[_l_result1];
		_in.read_double_array(_result,0,_l_result1);
		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, double[] _s)
	{
		
		_out.write_long(_s.length);
		_out.write_double_array(_s,0,_s.length);
	}
}
