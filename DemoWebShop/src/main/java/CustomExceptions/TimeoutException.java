package CustomExceptions;

@SuppressWarnings("serial")
public class TimeoutException extends Exception {
	
	public TimeoutException(String message) {
		super(message);
	}

}
