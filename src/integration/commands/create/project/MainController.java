package integration.commands.create.project;

import jcube.core.annotations.Bean;
import jcube.core.annotations.Valid;
import jcube.core.config.Configuration;
import jcube.core.dispatcher.URIDispatcher;
import jcube.core.server.Request;
import jcube.core.server.Response;
import jcube.core.session.Session;
import jcube.core.template.Template;
import jcube.core.ui.Email;

// TODO: Auto-generated Javadoc
/**
 * The Class MainController.
 */
public class MainController {
	
	/** Jcube core beans. */
	@Bean Template tpl;
	
	/** The request. */
	@Bean Request request;
	
	/** The response. */
	@Bean Response response;
	
	/** The dispatcher. */
	@Bean URIDispatcher dispatcher;
	
	/** The session. */
	@Bean Session session;
	
	/** The config. */
	@Bean Configuration config;
	
	/**
	 * Default page.
	 * Renders the main page
	 *
	 * @return the template
	 */
	public Template defaults()
	{
		return tpl;
	}
	
	/**
	 * Test.
	 *
	 * @param name the name
	 * @param email the email
	 * @return the string
	 */
	public String test(
			@Valid(msg="Name?") String name,
			@Valid Email email
	)
	{
		return "test is okay";
	}
	
}
