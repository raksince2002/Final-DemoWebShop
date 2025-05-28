package CustomExceptions;

@SuppressWarnings("serial")
public class RegistrationFailedException extends Exception {
	
	public RegistrationFailedException(String message) {
		super(message);
	}

}
