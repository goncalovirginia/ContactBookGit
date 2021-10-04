import contactBook.Contact;
import contactBook.ContactBookClass;
import contactBook.ContactClass;
import exceptions.ContactAlreadyExistsException;
import exceptions.ContactDoesNotExistException;
import exceptions.PhoneDoesNotExistException;

import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Gonçalo Virgínia (56773)
 * @author Miguel Real (55677)
 * @author Gabriela Costa (58625)
 */

public class Main {
	//Constantes que definem os comandos
	public static final String ADD_CONTACT = "AC";
	public static final String REMOVE_CONTACT = "RC";
	public static final String GET_PHONE = "GP";
	public static final String GET_EMAIL = "GE";
	public static final String SET_PHONE = "SP";
	public static final String SET_EMAIL = "SE";
	public static final String LIST_CONTACTS = "LC";
	public static final String EQUAL_PHONES = "EP";
	public static final String QUIT = "Q";
	public static final String GET_NAME = "GN";
	
	//Constantes que definem as mensagens para o utilizador
	public static final String CONTACT_ADDED = "contactBook.ContactClass added.";
	public static final String CONTACT_REMOVED = "contactBook.ContactClass removed.";
	public static final String CONTACT_UPDATED = "contactBook.ContactClass updated.";
	public static final String BOOK_EMPTY = "contactBook.ContactClass book empty.";
	public static final String QUIT_MSG = "Goodbye!";
	public static final String COMMAND_ERROR = "Unknown command.";
	public static final String EQUAL_NUMBERS_EXIST = "There are contacts that share phone numbers.";
	public static final String NO_EQUAL_NUMBERS_EXIST = "All contacts have different phone numbers.";
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ContactBookClass cBook = new ContactBookClass();
		String comm;
		
		do {
			comm = in.nextLine().toUpperCase();
			
			switch (comm) {
				case ADD_CONTACT -> addContact(in, cBook);
				case REMOVE_CONTACT -> deleteContact(in, cBook);
				case GET_PHONE -> getPhone(in, cBook);
				case GET_EMAIL -> getEmail(in, cBook);
				case SET_PHONE -> setPhone(in, cBook);
				case SET_EMAIL -> setEmail(in, cBook);
				case LIST_CONTACTS -> listAllContacts(cBook);
				case GET_NAME -> getName(in, cBook);
				case EQUAL_PHONES -> equalPhones(cBook);
				case QUIT -> System.out.println(QUIT_MSG);
				default -> System.out.println(COMMAND_ERROR);
			}
			System.out.println();
		}
		while (!comm.equals(QUIT));
		in.close();
	}
	
	private static void addContact(Scanner in, ContactBookClass cBook) {
		String name = in.nextLine();
		int phone = in.nextInt();
		in.nextLine();
		String email = in.nextLine();
		
		try {
			cBook.addContact(name, phone, email);
			System.out.println(CONTACT_ADDED);
		}
		catch (ContactAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void deleteContact(Scanner in, ContactBookClass cBook) {
		String name = in.nextLine();
		
		try {
			cBook.deleteContact(name);
			System.out.println(CONTACT_REMOVED);
		}
		catch (ContactDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void getPhone(Scanner in, ContactBookClass cBook) {
		String name = in.nextLine();
		
		try {
			System.out.println(cBook.getPhone(name));
		}
		catch (ContactDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void getEmail(Scanner in, ContactBookClass cBook) {
		String name = in.nextLine();
		
		try {
			System.out.println(cBook.getEmail(name));
		}
		catch (ContactDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void setPhone(Scanner in, ContactBookClass cBook) {
		String name = in.nextLine();
		int phone = in.nextInt();
		in.nextLine();
		
		try {
			cBook.setPhone(name, phone);
			System.out.println(CONTACT_UPDATED);
		}
		catch (ContactDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void setEmail(Scanner in, ContactBookClass cBook) {
		String name = in.nextLine(), email = in.nextLine();
		
		try {
			cBook.setEmail(name, email);
			System.out.println(CONTACT_UPDATED);
		}
		catch (ContactDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void listAllContacts(ContactBookClass cBook) {
		if (cBook.getNumberOfContacts() == 0) {
			System.out.println(BOOK_EMPTY);
		}
		else {
			Iterator<Contact> contactIterator = cBook.getContactIterator();
			while (contactIterator.hasNext()) {
				Contact c = contactIterator.next();
				System.out.println(c.getName() + "; " + c.getEmail() + "; " + c.getPhone());
			}
		}
	}
	
	private static void getName(Scanner in, ContactBookClass cBook) {
		int phone = in.nextInt();
		in.nextLine();
		
		try {
			System.out.println(cBook.getName(phone));
		}
		catch (PhoneDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void equalPhones(ContactBookClass cBook) {
		if (cBook.equalContacts()) {
			System.out.println(EQUAL_NUMBERS_EXIST);
		}
		else {
			System.out.println(NO_EQUAL_NUMBERS_EXIST);
		}
	}
	
}
