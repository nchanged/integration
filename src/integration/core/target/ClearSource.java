package integration.core.target;

import integration.core.response.Chain;
import integration.core.response.Element;
import integration.core.response.Response;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateDirectory.
 */
public class ClearSource implements Chain {
	
	/** The name. */
	protected String packages;
	protected String folder;
	
	/**
	 * Instantiates a new creates the directory.
	 *
	 * @param dir_name the dir_name
	 */
	public ClearSource(String folder, String packages)
	{
		this.packages = packages;
		this.folder = folder;
	}
	
	/* (non-Javadoc)
	 * @see integration.core.response.Chain#getResponse()
	 */
	@Override
	public Response getResponse() {
		Response response = new Response("clear-source");
		response.addElement(new Element("package", this.packages));
		response.addElement(new Element("folder", this.folder));
		return response;
	}
}
