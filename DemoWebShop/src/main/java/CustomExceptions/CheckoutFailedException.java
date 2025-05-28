package CustomExceptions;

@SuppressWarnings("serial")
public class CheckoutFailedException extends Exception {
	
	public CheckoutFailedException(String message) {
		super(message);
	}

}
