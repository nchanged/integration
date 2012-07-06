package integration.core.target;

import integration.core.response.Chain;
import integration.core.response.Element;
import integration.core.response.Response;

public class DownloadTextFile implements Chain {
	
	public String path;
	
	/** The target_directory. */
	public String target_directory;
	
	public DownloadTextFile(String path, String target_directory)
	{
		this.path = path;
		this.target_directory = target_directory;
	}
	@Override
	public Response getResponse() {
		Response response = new Response("download-textfile");
		response.addElement(new Element("url", this.path));
		response.addElement(new Element("target_directory", this.target_directory));
		return response;
	}

}
