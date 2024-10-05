package TextProcessing;

/**
 * Generated from IDL struct "WordFrequency".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at Oct 5, 2024, 2:04:38 PM
 */

public final class WordFrequency
	implements org.omg.CORBA.portable.IDLEntity
{
	/** Serial version UID. */
	private static final long serialVersionUID = 1L;
	public WordFrequency(){}
	public java.lang.String word = "";
	public int frequency;
	public WordFrequency(java.lang.String word, int frequency)
	{
		this.word = word;
		this.frequency = frequency;
	}
}
