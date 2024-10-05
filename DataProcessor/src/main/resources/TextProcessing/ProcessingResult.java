package TextProcessing;

/**
 * Generated from IDL struct "ProcessingResult".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at Oct 5, 2024, 2:04:38 PM
 */

public final class ProcessingResult
	implements org.omg.CORBA.portable.IDLEntity
{
	/** Serial version UID. */
	private static final long serialVersionUID = 1L;
	public ProcessingResult(){}
	public TextProcessing.WordFrequency[] wordFrequencies;
	public TextProcessing.WordMap[] wordMappings;
	public double[] vectorEmbedding;
	public ProcessingResult(TextProcessing.WordFrequency[] wordFrequencies, TextProcessing.WordMap[] wordMappings, double[] vectorEmbedding)
	{
		this.wordFrequencies = wordFrequencies;
		this.wordMappings = wordMappings;
		this.vectorEmbedding = vectorEmbedding;
	}
}
