package integration.core.target;

import integration.core.response.Chain;
import integration.core.response.Element;
import integration.core.response.Response;

public class MakeRunnable implements Chain {
	String name;
	public MakeRunnable(String file)
	{
		this.name = file;
	}
	
	@Override
	public Response getResponse() {
		Response response = new Response("make-runnable");
		response.addElement(new Element("file", this.name));
		return response;
	}

}
