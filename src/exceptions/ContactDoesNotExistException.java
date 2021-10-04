package exceptions;

public class ContactDoesNotExistException extends RuntimeException {
	
	public ContactDoesNotExistException() {
		super("contactBook.Contact does not exist.");
	}
	
}
