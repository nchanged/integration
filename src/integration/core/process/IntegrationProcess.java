package integration.core.process;

import java.util.ArrayList;

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
	 *
	 * @param destination the destination
	 * @throws InvalidParameters the invalid parameters
	 */
	public IntegrationProcess(Class<?> destination) throws InvalidParameters
	{
		try {
			this.integration =  (Intergation) destination.newInstance();
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
