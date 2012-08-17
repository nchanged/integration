package integration.core.target;

import integration.core.response.Chain;
import integration.core.response.Element;
import integration.core.response.Response;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateDirectory.
 */
public class CopyResource implements Chain {
	
	/**
	 * Instantiates a new creates the directory.
	 *
	 * @param dir_name the dir_name
	 */
	public CopyResource()
	{
	}
	
	/* (non-Javadoc)
	 * @see integration.core.response.Chain#getResponse()
	 */
	@Override
	public Response getResponse() {
		Response response = new Response("copy-resource");
		response.addElement(new Element("file", "{project-path}/.jcube-build-path"));
		response.addElement(new Element("ignore", "{project-path}/.jcube-build-ignore"));
		return response;
	}
}
