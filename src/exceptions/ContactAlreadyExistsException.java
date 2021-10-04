package exceptions;

public class ContactAlreadyExistsException extends RuntimeException {
	
	public ContactAlreadyExistsException() {
		super("contactBook.Contact already exists.");
	}
	
}
