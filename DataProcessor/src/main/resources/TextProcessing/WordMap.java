package TextProcessing;

/**
 * Generated from IDL struct "WordMap".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at Oct 5, 2024, 2:04:38 PM
 */

public final class WordMap
	implements org.omg.CORBA.portable.IDLEntity
{
	/** Serial version UID. */
	private static final long serialVersionUID = 1L;
	public WordMap(){}
	public java.lang.String word = "";
	public int uid;
	public WordMap(java.lang.String word, int uid)
	{
		this.word = word;
		this.uid = uid;
	}
}
