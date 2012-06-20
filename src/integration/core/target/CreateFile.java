package integration.core.target;

import integration.core.response.Chain;
import integration.core.response.Element;
import integration.core.response.Response;

public class CreateFile implements Chain {
	protected String filepath; 
	protected String contents;
	public CreateFile(String filepath, String contents)
	{
		this.filepath = filepath;
		this.contents = contents;
	}
	
	public CreateFile(String filepath)
	{
		this.filepath = filepath;
	}
	
	@Override
	public Response getResponse() {
		Response response = new Response("create-file");
		response.addElement(new Element("name", this.filepath));
		if ( contents != null )
			response.addElement(new Element("contents", this.contents));
		return response;
	}

}
