package integration.commands.install.velocitytools;

import java.util.ArrayList;

import integration.core.response.Chain;
import integration.core.response.Intergation;
import integration.core.target.Dependency;
import integration.core.target.DownloadTextFile;

public class Main implements Intergation {

	@Override
	public ArrayList<Chain> getChains() {
		ArrayList<Chain> chains = new ArrayList<Chain>();
		chains.add( new Dependency("velocity-tools-generic", "2.0.0") );
		chains.add( new Dependency("velocity-tools-view", "2.0.0") );
		chains.add( new Dependency("velocity-tools", "2.0.0") );
		chains.add( new Dependency("commons-digester", "1.8.0") );
		chains.add( new Dependency("commons-beanutils", "1.7.0") );
		chains.add( new Dependency("commons-logging", "1.1.0") );
		chains.add( new DownloadTextFile("resources/velocity-tool/velocity-tools.xml", 
				"{project-path}/config/") );
		return chains;
	}

}
