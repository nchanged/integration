package integration.core.process;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import jcube.core.server.Environ;

import integration.core.exception.InvalidParameters;
import integration.core.response.Chain;
import integration.core.response.Intergation;

// TODO: Auto-generated Javadoc
/**
 * The Class IntegrationProcess.
 */
public class IntegrationProcess {
	
	/** The destination. */
	Intergation integration;
	
	/**
	 * Instantiates a new integration process.
	 * @param environ 
	 *
	 * @param destination the destination
	 * @throws InvalidParameters the invalid parameters
	 */
	public IntegrationProcess(Environ environ, Class<?> destination) throws InvalidParameters
	{
		try {
			Constructor<?> constructor = destination.getConstructor(Environ.class);
			Object[] constructorArgs =
			{ environ };
			
			this.integration =  (Intergation)  constructor.newInstance(constructorArgs);
			
			
		} catch ( Exception e) {
			throw new InvalidParameters("Error occured during command");
		}
	}
	
	/**
	 * Grab information.
	 *
	 * @return the array list
	 */
	public ArrayList<Object> getEntire()
	{
		ArrayList<Object> data = new ArrayList<Object>();
		for(Chain chain : integration.getChains() ) 
			data.add(chain.getResponse().getConverter().getOut());
		return data;
	}
}
