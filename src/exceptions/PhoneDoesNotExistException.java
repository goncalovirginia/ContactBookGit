package exceptions;

public class PhoneDoesNotExistException extends RuntimeException {
	
	public PhoneDoesNotExistException() {
		super("Phone number does not exist.");
	}
	
}
