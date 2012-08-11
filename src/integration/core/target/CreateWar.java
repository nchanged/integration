package integration.core.target;

import integration.core.response.Chain;
import integration.core.response.Element;
import integration.core.response.Response;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateDirectory.
 */
public class CreateWar implements Chain {
	
	/** The name. */
	protected String source;
	protected String target;
	
	/**
	 * Instantiates a new creates the directory.
	 *
	 * @param dir_name the dir_name
	 */
	public CreateWar(String source, String target)
	{
		this.source = source;
		this.target = target;
	}
	
	/* (non-Javadoc)
	 * @see integration.core.response.Chain#getResponse()
	 */
	@Override
	public Response getResponse() {
		Response response = new Response("create-war");
		response.addElement(new Element("source", this.source));
		response.addElement(new Element("target", this.target));
		return response;
	}
}
