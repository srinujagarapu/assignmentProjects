package assignment.StoreRestApp.exception;

/**
 * Custom Exception class
 * @author JSRINU
 *
 */
public class StoreManagementException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private String errorDescription;
	private String errorCode;
	
    public StoreManagementException() {
    	
    }
	public StoreManagementException(String errorDescription, String errorCode) {
		super(errorDescription);
		this.errorDescription = errorDescription;
		this.errorCode = errorCode;
		
		
    }

	public String getErrorDescription() {
		return errorDescription;
	}

	
	public String getErrorCode() {
		return errorCode;
	}

	

}
