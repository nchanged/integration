package integration.core.reciever;

import java.util.HashMap;
import flexjson.JSONSerializer;
import jcube.core.server.Environ;

// TODO: Auto-generated Javadoc
/**
 * The Class Catcher.
 */
public class Catcher {
	
	/** Instantiates a new catcher. Prints exceptions */
	Environ env;
	
	/**
	 * Instantiates a new catcher.
	 *
	 * @param env the env
	 * @param e the e
	 */
	public Catcher(Environ env, Exception e)
	{
		this.env = env;
		String error = this.getMessage(e);
		this.printError( error );
	}
	
	/**
	 * Gets the message.
	 *
	 * @param e the e
	 * @return the message
	 */
	public String getMessage(Exception e)
	{
		String message = e.getMessage();
		if ( message == null )
			if (e.getCause() != null && e.getCause().getMessage() != null )
				message = e.getCause().getMessage();
		return message;
	}
	
	/**
	 * Prints the error.
	 *
	 * @param message the message
	 */
	public void printError( String message )
	{
		HashMap<String,String> result = new HashMap<String,String>();
		result.put("error",message);
		env.getResponse().setDisplayTextData(new JSONSerializer().deepSerialize(result));
		env.getRequest().setAjax(true);
	}
}
