package integration.core.target;

import integration.core.response.Chain;
import integration.core.response.Element;
import integration.core.response.Response;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateDirectory.
 */
public class CreateDirectoryRecursive implements Chain {
	
	/** The name. */
	protected String name;
	
	/**
	 * Instantiates a new creates the directory.
	 *
	 * @param dir_name the dir_name
	 */
	public CreateDirectoryRecursive(String dir_name)
	{
		this.name = dir_name;
	}
	
	/* (non-Javadoc)
	 * @see integration.core.response.Chain#getResponse()
	 */
	@Override
	public Response getResponse() {
		Response response = new Response("create-directoryrecursive");
		response.addElement(new Element("name", this.name));
		return response;
	}
}
