package integration.commands.create.project;

import integration.core.response.Chain;
import integration.core.response.Intergation;
import integration.core.target.*;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main implements Intergation {
	
	/* (non-Javadoc)
	 * @see integration.core.response.Intergation#getChains()
	 */
	@Override
	public ArrayList<Chain> getChains() {
		ArrayList<Chain> chains = new ArrayList<Chain>();
		chains.add( new CreateDirectory("templates/main") );
		chains.add( new CreateFile("templates/data/1.txt", "contents") );
		chains.add( new DownloadFile("templates/data/1.txt", "/target") );
		return chains;
	}
}
