package integration.commands.deploy;

import integration.core.response.Chain;
import integration.core.response.Intergation;
import integration.core.target.*;

import java.util.ArrayList;

import jcube.core.server.Environ;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main implements Intergation {
	Environ environ;
	public Main(Environ environ){
		this.environ = environ;
	}
	/* (non-Javadoc)
	 * @see integration.core.response.Intergation#getChains()
	 */
	@Override
	public ArrayList<Chain> getChains() {
		ArrayList<Chain> chains = new ArrayList<Chain>();
		
		chains.add( new CreateDirectory("{project-path}/WEB-INF/") );
		chains.add( new CreateDirectory("{project-path}/WEB-INF/bin") );
		chains.add( new DownloadTextFile("resources/deploy/web.xml","{project-path}/WEB-INF/") );
		chains.add(new CopyDirectory("{project-path}/bin", "{project-path}/WEB-INF/bin"));
		chains.add(new CreateWar("{project-path}/WEB-INF", "{project-path}/{project-package}.war"));
	
		return chains;
	}
}
