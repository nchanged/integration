package integration.controller;
import java.util.ArrayList;

import integration.core.reciever.Catcher;
import integration.core.reciever.CommandReciever;
import jcube.core.annotations.CatchMe;
import jcube.core.annotations.Jsonify;

/**
 * The Class MainController.
 */
@CatchMe(into=Catcher.class)
public class MainController {
    
    /**
     * Defaults.
     *
     * @param template the template
     * @return the object
     */
	@Jsonify
    public ArrayList<Object> defaults(String command, String option) throws Exception
    {
        CommandReciever reciever;
		reciever = new CommandReciever(command, option);
    	return reciever.getOut();
    }
}