package integration.core.reciever;
import java.util.ArrayList;

import flexjson.JSONSerializer;
import integration.core.converter.PackageConverter;
import integration.core.exception.InvalidParameters;
import integration.core.process.IntegrationProcess;
import integration.core.response.Intergation;


// TODO: Auto-generated Javadoc
/**
 * The Class Command.
 */
public class Command {
	
	Class<?> destination = null;
	/**
	 * Instantiates a new command.
	 *
	 * @param cmd the cmd
	 * @param option the option
	 * @throws InvalidParameters the invalid parameters
	 */
	public Command(String cmd, String option) throws InvalidParameters
	{
		if ( cmd == null )
			throw new InvalidParameters("You sould specify the command");
		
		PackageConverter converter = new PackageConverter(cmd);
		
		if ( (destination = converter.getDestinationClass()) == null )
			throw new InvalidParameters("Command not found");
		
		// Get the process
		
		
	}
	
	protected IntegrationProcess getProcess() throws InvalidParameters
	{
		return new IntegrationProcess(destination);
	}
	
	public ArrayList<Object> getOut() throws InvalidParameters
	{
		IntegrationProcess process = this.getProcess();
		return process.getEntire();
	}
	
	
	/**
	 * Gets the integration.
	 *
	 * @param destination the destination
	 * @return the integration
	 * @throws InvalidParameters the invalid parameters
	 */
	public Intergation getIntegration(Class<?> destination) throws InvalidParameters
	{
		try {
			return (Intergation) destination.newInstance();
		} catch ( Exception e) {
			throw new InvalidParameters("Error occured during command");
		}	
	}
}
