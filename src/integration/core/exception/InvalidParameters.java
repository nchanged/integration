package integration.core.exception;

public class InvalidParameters extends Exception {

	/**
	 * 
	 */
	
	private String message;
	private static final long serialVersionUID = 1L;

	public InvalidParameters() {
		// TODO Auto-generated constructor stub
	}

	public InvalidParameters(String arg0) {
		super(arg0);
		this.message = arg0;
		// TODO Auto-generated constructor stub
	}

	public InvalidParameters(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public InvalidParameters(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
	
	public String getMessage()
	{
		return this.message; 
	}

}
