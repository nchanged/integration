package integration.core.target;

import integration.core.response.Chain;
import integration.core.response.Element;
import integration.core.response.Response;

// TODO: Auto-generated Javadoc
/**
 * The Class DownloadFile.
 */
public class DownloadFile implements Chain {
	
	/** The path. */
	public String path;
	
	/** The target_directory. */
	public String target_directory;
	
	public Boolean unpack = false;
	
	
	/**
	 * Instantiates a new download file.
	 *
	 * @param path the path
	 * @param target_directory the target_directory
	 */
	public DownloadFile(String path, String target_directory)
	{
		this.path = path;
		this.target_directory = target_directory;
	}
	
	public DownloadFile unpack()
	{
		this.unpack = true;
		return this;
	}
	
	/* (non-Javadoc)
	 * @see integration.core.response.Chain#getResponse()
	 */
	@Override
	public Response getResponse() {
		Response response = new Response("download-file");
		response.addElement(new Element("url", this.path));
		response.addElement(new Element("target_directory", this.target_directory));
		response.addElement(new Element("unpack", this.unpack));
		return response;
	}

}
