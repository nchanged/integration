package integration.core.target;

import integration.core.response.Chain;
import integration.core.response.Element;
import integration.core.response.Response;

public class UpdateHelper implements Chain {

	@Override
	public Response getResponse() {
		Response response = new Response("update-helper");
		response.addElement(new Element("metadata", "http://repository.javacube.net/files/helper/metadata.xml"));
		response.addElement(new Element("file", "http://repository.javacube.net/files/helper/jcube"));
		
		return response;
	}

}
