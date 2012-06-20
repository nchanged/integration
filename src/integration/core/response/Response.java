package integration.core.response;

import integration.core.converter.ResponseConverter;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Response.
 */
public class Response {
	
	/** The action_name. */
	private String action_name;
	
	/** The list_elements. */
	private ArrayList<Element> list_elements 
		= new ArrayList<Element>();
	
	/** The elements. */
	private ArrayList<Element> elements 
		= new ArrayList<Element>();
	
	/**
	 * Instantiates a new response.
	 *
	 * @param name the name
	 */
	public Response(String name){
		setActionName(name);
	}
	
	/**
	 * Sets the action name.
	 *
	 * @param name the name
	 * @return the response
	 */
	public Response setActionName(String name)
	{
		this.action_name = name;
		return this;
	}

	/**
	 * Gets the action name.
	 *
	 * @return the action name
	 */
	public String getActionName() {
		return action_name;
	}
	
	/**
	 * Adds the list element.
	 *
	 * @param element the element
	 */
	public void addListElement(Element element){
		this.list_elements.add(element);
	}
	
	/**
	 * Adds the element.
	 *
	 * @param element the element
	 */
	public void addElement(Element element){
		this.elements.add(element);
	}
	
	/**
	 * Gets the elements.
	 *
	 * @return the elements
	 */
	public ArrayList<Element> getElements()
	{
		return this.elements;
	}
	
	
	/**
	 * Gets the list elements.
	 *
	 * @return the list elements
	 */
	public ArrayList<Element> getListElements()
	{
		return this.list_elements;
	}
	
	public ResponseConverter getConverter()
	{
		return new ResponseConverter(this);
	}
}
