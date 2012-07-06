package integration.core.target;

import integration.core.response.Chain;
import integration.core.response.Element;
import integration.core.response.Response;

public class Dependency implements Chain {
	String name; 
	String version;
	public Dependency(String name, String version)
	{
		this.name = name;
		this.version = version;
		
	}
	@Override
	public Response getResponse() {
		Response response = new Response("resolve-dependency");
		response.addElement(new Element("name", name));
		response.addElement(new Element("version", version));
		return response;
	}

}
