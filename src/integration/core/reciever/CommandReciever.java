package integration.core.reciever;

import java.util.ArrayList;

import jcube.core.server.Environ;

import integration.core.exception.InvalidParameters;


/**
 * The Class CommandReciever.
 *
 * @author iorlov
 */
public class CommandReciever {
	protected Command command;
	protected Environ environ;
	/**
	 * Instantiates a new command reciever.
	 *
	 * @param command the command
	 * @param options the options
	 * @throws InvalidParameters 
	 */
	public CommandReciever(Environ environ, String cmd, String options) throws InvalidParameters
	{
		this.environ = environ;
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
		
		return new Command(environ, command, option);
	}
}
