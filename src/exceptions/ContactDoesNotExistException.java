package exceptions;

public class ContactDoesNotExistException extends RuntimeException {
	
	public ContactDoesNotExistException() {
		super("contactBook.ContactClass does not exist.");
	}
	
}
