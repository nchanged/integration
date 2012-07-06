package integration.core.target;

import integration.core.response.Chain;
import integration.core.response.Element;
import integration.core.response.Response;
import jcube.core.server.Environ;
import jcube.core.string.helpers.JcubeFileHandler;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateJavaClass.
 */
public class CreateJavaClass implements Chain {
	
	/** The env. */
	Environ env;
	
	/** The class_name. */
	Class<?> class_name;
	
	/** The destination_class. */
	String destination_class;
	
	/**
	 * Instantiates a new creates the java class.
	 *
	 * @param env the env
	 * @param class_name the class_name
	 * @param destination_class the destination_class
	 */
	public CreateJavaClass(Environ env, Class<?> class_name, String destination_class)
	{
		this.env = env;
		this.class_name = class_name;
		this.destination_class = destination_class;
	}
	
	/**
	 * Gets the file contents.
	 *
	 * @return the file contents
	 * @throws Exception the exception
	 */
	public String getFileContents() throws Exception
	{
		String src_folder = env.getConfiguration().getString("src-folder");
		String class_path = src_folder + "/" + class_name.getCanonicalName().replace(".", "/") + ".java";
		return JcubeFileHandler.readAsString(class_path);
	}
	
	/* (non-Javadoc)
	 * @see integration.core.response.Chain#getResponse()
	 */
	@Override
	public Response getResponse() {
		try {
			Response response = new Response("java-class");
			response.addElement(new Element("destination", destination_class));
			response.addElement(new Element("contents", getFileContents()));
			return response;
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
