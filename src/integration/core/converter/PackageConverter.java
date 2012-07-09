package integration.core.converter;


// TODO: Auto-generated Javadoc
/**
 * The Class PackageConverter.
 */
public class PackageConverter {
	
	/** The default_class_name. */
	private String default_class_name = "Main";
	/** The first. */
	String first = null;
	
	/** The second. */
	String second = null;
	
	/**
	 * Instantiates a new package converter.
	 *
	 * @param cmd the cmd
	 */
	public PackageConverter(String cmd)
	{
		String[] c = cmd.split("-");
		if ( c.length >= 1 ) first = c[0];
		if ( c.length == 2 )
			second = c[1];	
		
	}
	
	/**
	 * Gets the destination class.
	 *
	 * @return the destination class
	 */
	public Class<?> getDestinationClass()
	{
		Class<?> target = null;
		if ( second == null )
			target = tryClass(first);
		else 
			target = tryClass(first + "." + second);
		return target;
	}
	
	/**
	 * Try class.
	 *
	 * @param data the data
	 * @return the class
	 */
	public Class<?> tryClass(String data)
	{
		
		try {
			
			return Class.forName(getClassTargetName(data));
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	/**
	 * Gets the default class name.
	 *
	 * @return the default class name
	 */
	public String getDefaultClassName() {
		return default_class_name;
	}

	/**
	 * Sets the default class name.
	 *
	 * @param default_class_name the new default class name
	 */
	public void setDefaultClassName(String default_class_name) {
		this.default_class_name = default_class_name;
	}
	
	
	/**
	 * Gets the class target name.
	 *
	 * @param in the in
	 * @return the class target name
	 */
	public String getClassTargetName(String in){
		return "integration.commands." + in + "." + this.getDefaultClassName(); 
	}
}
