package TextProcessing;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "FileProcessor".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at Oct 5, 2024, 2:04:38 PM
 */

public class FileProcessorPOATie
	extends FileProcessorPOA
{
	private FileProcessorOperations _delegate;

	private POA _poa;
	public FileProcessorPOATie(FileProcessorOperations delegate)
	{
		_delegate = delegate;
	}
	public FileProcessorPOATie(FileProcessorOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public TextProcessing.FileProcessor _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		TextProcessing.FileProcessor __r = TextProcessing.FileProcessorHelper.narrow(__o);
		return __r;
	}
	public TextProcessing.FileProcessor _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		TextProcessing.FileProcessor __r = TextProcessing.FileProcessorHelper.narrow(__o);
		return __r;
	}
	public FileProcessorOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(FileProcessorOperations delegate)
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
	public TextProcessing.ProcessingResult processChunk(java.lang.String chunkContent)
	{
		return _delegate.processChunk(chunkContent);
	}

	public void writeResults(TextProcessing.ProcessingResult results)
	{
_delegate.writeResults(results);
	}

}
