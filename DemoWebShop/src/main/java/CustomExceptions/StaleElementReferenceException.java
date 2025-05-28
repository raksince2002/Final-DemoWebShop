package CustomExceptions;

@SuppressWarnings("serial")
public class StaleElementReferenceException extends Exception {
	
	public StaleElementReferenceException(String message) {
		super(message);
	}

}
