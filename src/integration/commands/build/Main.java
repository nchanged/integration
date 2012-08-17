package integration.commands.build;

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
		
		chains.add( new ClearSource("{project-path}/.build", "{project-path}/{project-package}.war") );
		
		chains.add( new CreateDirectory("{project-path}/.build/WEB-INF/classes") );
		
		chains.add(new CompileSource("{project-path}/src", "{project-path}/.build/WEB-INF/classes"));
		
		chains.add( new DownloadTextFile("resources/create-project/config/web.xml","{project-path}/.build/WEB-INF/") );
		chains.add( new CreateFile("{project-path}/.build/WEB-INF/classes/server.properties","jcube.config=webapps/{project-package}/config/application.xml") );
		
		
		chains.add( new CopyDirectory("{project-path}/config","{project-path}/.build/") );
		chains.add( new CopyDirectory("{project-path}/templates","{project-path}/.build/") );
		chains.add( new CopyDirectory("{project-path}/static","{project-path}/.build/") );
		chains.add( new CopyResource());
		
		chains.add(new CreateWar("{project-path}/.build", "{project-path}/{project-package}.war"));
		
		//chains.add(new RemoveDirectory("{project-path}/.build"));
		
		return chains;
	}
}
