package integration.commands.update;

import java.util.ArrayList;

import integration.core.response.Chain;
import integration.core.response.Intergation;
import integration.core.target.Dependency;
import integration.core.target.UpdateHelper;

public class Main implements Intergation {

	@Override
	public ArrayList<Chain> getChains() {
		ArrayList<Chain> chains = new ArrayList<Chain>();
		
		chains.add( new UpdateHelper() );
		chains.add( new Dependency("jcube-framework", "1.0.0") );
		chains.add( new Dependency("jcube-activerecord", "1.0.0") );
		chains.add( new Dependency("jcube-helpers", "1.0.0") );
		chains.add( new Dependency("apache-velocity", "1.6.2") );
		chains.add( new Dependency("velocity-tools-generic", "2.0.0") );
		chains.add( new Dependency("velocity-tools-view", "2.0.0") );
		chains.add( new Dependency("velocity-tools", "2.0.0") );
		chains.add( new Dependency("commons-digester", "1.8.0") );
		
		chains.add( new Dependency("commons-codec", "1.4.0") );
		chains.add( new Dependency("commons-collections", "3.2.1") );
		chains.add( new Dependency("commons-io", "2.1.0") );
		chains.add( new Dependency("commons-lang", "2.6.0") );
		chains.add( new Dependency("flexjson", "2.0.0") );
		chains.add( new Dependency("simple-http", "4.1.2") );
		chains.add( new Dependency("mysql-connector-java", "5.1.13") );
		chains.add( new Dependency("postgresql", "9.0.8") );
		chains.add( new Dependency("sqlitejdbc", "0.5.6") );
		
		return chains;
	}

}
