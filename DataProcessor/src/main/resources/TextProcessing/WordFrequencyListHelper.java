package TextProcessing;

/**
 * Generated from IDL alias "WordFrequencyList".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at Oct 5, 2024, 2:04:38 PM
 */

public abstract class WordFrequencyListHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;

	public static void insert (org.omg.CORBA.Any any, TextProcessing.WordFrequency[] s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static TextProcessing.WordFrequency[] extract (final org.omg.CORBA.Any any)
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
			synchronized(WordFrequencyListHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_alias_tc(TextProcessing.WordFrequencyListHelper.id(), "WordFrequencyList",org.omg.CORBA.ORB.init().create_sequence_tc(0, org.omg.CORBA.ORB.init().create_struct_tc(TextProcessing.WordFrequencyHelper.id(),"WordFrequency",new org.omg.CORBA.StructMember[]{new org.omg.CORBA.StructMember("word", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("frequency", org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(3)), null)})));
				}
			}
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:TextProcessing/WordFrequencyList:1.0";
	}
	public static TextProcessing.WordFrequency[] read (final org.omg.CORBA.portable.InputStream _in)
	{
		TextProcessing.WordFrequency[] _result;
		int _l_result2 = _in.read_long();
		try
		{
			 int x = _in.available();
			 if ( x > 0 && _l_result2 > x )
				{
					throw new org.omg.CORBA.MARSHAL("Sequence length too large. Only " + x + " available and trying to assign " + _l_result2);
				}
		}
		catch (java.io.IOException e)
		{
		}
		_result = new TextProcessing.WordFrequency[_l_result2];
		for (int i=0;i<_result.length;i++)
		{
			_result[i]=TextProcessing.WordFrequencyHelper.read(_in);
		}

		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, TextProcessing.WordFrequency[] _s)
	{
		
		_out.write_long(_s.length);
		for (int i=0; i<_s.length;i++)
		{
			TextProcessing.WordFrequencyHelper.write(_out,_s[i]);
		}

	}
}
