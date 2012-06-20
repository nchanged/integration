package integration.core.response;

// TODO: Auto-generated Javadoc
/**
 * The Class Element.
 */
public class Element {
	
	/** The key. */
	private String key;
	
	/** The value. */
	private Object value;
	
	/**
	 * Instantiates a new element.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public Element(String key, Object value){
		this.key = key;
		this.value = value;
	}
	
	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public String getKey()
	{
		return key;
	}
	
	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public Object getValue()
	{
		return value;
	}
}
