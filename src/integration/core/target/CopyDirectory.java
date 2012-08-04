package integration.core.target;

import integration.core.response.Chain;
import integration.core.response.Element;
import integration.core.response.Response;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateDirectory.
 */
public class CopyDirectory implements Chain {
	
	/** The name. */
	protected String name;
	protected String target;
	
	/**
	 * Instantiates a new creates the directory.
	 *
	 * @param dir_name the dir_name
	 */
	public CopyDirectory(String source_name, String target_name)
	{
		this.name = source_name;
		this.target = target_name;
	}
	
	/* (non-Javadoc)
	 * @see integration.core.response.Chain#getResponse()
	 */
	@Override
	public Response getResponse() {
		Response response = new Response("copy-directory");
		response.addElement(new Element("source", this.name));
		response.addElement(new Element("target", this.target));
		return response;
	}
}
