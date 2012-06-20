package integration.core.converter;

import java.util.ArrayList;
import java.util.HashMap;

import integration.core.response.Element;
import integration.core.response.Response;


// TODO: Auto-generated Javadoc
/**
 * The Class ResponseConverter.
 */
public class ResponseConverter {
	
	/** The response. */
	Response response;
	
	/**
	 * Instantiates a new response converter.
	 *
	 * @param response the response
	 */
	public ResponseConverter(Response response) {
		this.response = response;
	}
	
	/**
	 * Gets the out.
	 *
	 * @return the out
	 */
	public Object getOut()
	{
		HashMap<String,Object> result = new HashMap<String,Object>();
		
		ArrayList<HashMap<String,Object>> array_list_of_element 
			= new ArrayList<HashMap<String,Object>>();
		
		HashMap<String,Object> elements = new HashMap<String, Object>();
		if ( response.getListElements().size() > 0 ){
			for(Element element : response.getListElements() ){
				HashMap<String,Object> current = new HashMap<String, Object>();
				current.put(element.getKey(), element.getValue());
				array_list_of_element.add(current);
			}
		} else {
				for(Element element : response.getElements() )
					elements.put(element.getKey(), element.getValue());
		}
		
		if ( array_list_of_element.size() > 0){
			result.put(response.getActionName(), array_list_of_element);
			return result;
		}
		result.put(response.getActionName(), elements);
		return result;
	}
}