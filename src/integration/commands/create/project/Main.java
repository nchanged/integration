package integration.commands.create.project;

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
		
		
		// Resolving dependencies *********************************************************
		chains.add( new Dependency("jcube-framework", "1.0.0") );
		chains.add( new Dependency("jcube-activerecord", "1.0.0") );
		chains.add( new Dependency("jcube-helpers", "1.0.0") );
		chains.add( new Dependency("apache-velocity", "1.6.2") );
		chains.add( new Dependency("commons-codec", "1.4.0") );
		chains.add( new Dependency("commons-collections", "3.2.1") );
		chains.add( new Dependency("commons-io", "2.1.0") );
		chains.add( new Dependency("commons-lang", "2.6.0") );
		chains.add( new Dependency("flexjson", "2.0.0") );
		chains.add( new Dependency("simple-http", "4.1.2") );
		chains.add( new Dependency("mysql-connector-java", "5.1.13") );
		chains.add( new Dependency("postgresql", "9.0.8") );
		chains.add( new Dependency("sqlitejdbc", "0.5.6") );
		
	
		
		// Creating basic java packages ****************************************************
		chains.add( new CreateDirectory("{project-path}/bin/") );
		chains.add( new CreateDirectory("{project-path}/src/{project-package}/controller") );
		chains.add( new CreateDirectory("{project-path}/src/{project-package}/model") );
		//chains.add( new CreateDirectory("{project-path}/src/{project-package}/filters") );
		//chains.add( new CreateDirectory("{project-path}/src/{project-package}/beans") );
		chains.add( new CreateDirectory("{project-path}/templates/main") );

		// config files *******************************************************************
		chains.add( new CreateDirectory("{project-path}/config/") );
		// application.xml
		chains.add( new DownloadTextFile("resources/create-project/config/application.xml", 
					"{project-path}/config/") );
		// beans configuration
		chains.add( new DownloadTextFile("resources/create-project/config/beans.xml", 
				"{project-path}/config/") );
		// controller configuration
		chains.add( new DownloadTextFile("resources/create-project/config/controller.xml", 
				"{project-path}/config/") );
		// database configuration
		chains.add( new DownloadTextFile("resources/create-project/config/db.xml", 
				"{project-path}/config/") );
		// filter configuration
		chains.add( new DownloadTextFile("resources/create-project/config/filters.xml", 
				"{project-path}/config/") );
		// startup configuration
		chains.add( new DownloadTextFile("resources/create-project/config/startup.xml", 
				"{project-path}/config/") );
		chains.add( new DownloadTextFile("resources/create-project/bash/run.sh", 
				"{project-path}/") );
		
		chains.add( new DownloadTextFile("resources/create-project/css/jcube-form.css", 
				"{project-path}/static/css/") );
		chains.add( new DownloadTextFile("resources/create-project/css/layout.css", 
				"{project-path}/static/css/") );
		chains.add( new DownloadTextFile("resources/create-project/js/jcube-form.js", 
				"{project-path}/static/js/") );
		chains.add( new DownloadTextFile("resources/create-project/templates/defaults.htm", 
				"{project-path}/templates/main/") );
		
		// Creating runner
		chains.add( new CreateJavaClass(environ, 
				integration.commands.create.project.RunDevelop.class, 
				"{project-package}") 
			);
		
		// Creating MainController
		chains.add( new CreateJavaClass(environ, 
			integration.commands.create.project.MainController.class, 
			"{project-package}.controller.MainController") 
		);
	
		return chains;
	}
}
