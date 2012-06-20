package integration.core.reciever;

import java.util.ArrayList;

import integration.core.exception.InvalidParameters;


/**
 * The Class CommandReciever.
 *
 * @author iorlov
 */
public class CommandReciever {
	Command command;
	/**
	 * Instantiates a new command reciever.
	 *
	 * @param command the command
	 * @param options the options
	 * @throws InvalidParameters 
	 */
	public CommandReciever(String cmd, String options) throws InvalidParameters
	{
		command = this.getCommand(cmd, options);	
	}
	
	/**
	 * Gets the out.
	 *
	 * @return the out
	 * @throws InvalidParameters 
	 */
	public ArrayList<Object> getOut() throws InvalidParameters
	{
		return command.getOut();
	}
	
	
	public Command getCommand(String command, String option) throws InvalidParameters
	{
		return new Command(command, option);
	}
}
