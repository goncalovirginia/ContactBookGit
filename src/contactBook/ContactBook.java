package contactBook;

import contactBook.Contact;
import exceptions.ContactAlreadyExistsException;
import exceptions.ContactDoesNotExistException;
import exceptions.PhoneDoesNotExistException;

import java.util.*;

public class ContactBook {
	
	private List<Contact> contacts;
	
	public ContactBook() {
		contacts = new LinkedList<>();
	}
	
	//Pre: name != null
	private Contact findContact(String name) {
		for (Contact contact : contacts) {
			if (contact.getName().equals(name)) {
				return contact;
			}
		}
		return null;
	}
	
	private Contact findContact(int phone) {
		for (Contact contact : contacts) {
			if (contact.getPhone() == phone) {
				return contact;
			}
		}
		return null;
	}
	
	public int getNumberOfContacts() {
		return contacts.size();
	}
	
	//Pre: name!= null && !hasContact(name)
	public void addContact(String name, int phone, String email) {
		if (findContact(name) != null) {
			throw new ContactAlreadyExistsException();
		}
		contacts.add(new Contact(name, phone, email));
	}
	
	//Pre: name != null && hasContact(name)
	public void deleteContact(String name) {
		if (!contacts.removeIf(contact -> contact.getName().equals(name))) {
			throw new ContactDoesNotExistException();
		}
	}
	
	//Pre: name != null && hasContact(name)
	public int getPhone(String name) {
		Contact contact = findContact(name);
		
		if (contact == null) {
			throw new ContactDoesNotExistException();
		}
		return contact.getPhone();
	}
	
	//Pre: name != null && hasContact(name)
	public String getEmail(String name) {
		Contact contact = findContact(name);
		
		if (contact == null) {
			throw new ContactDoesNotExistException();
		}
		return contact.getEmail();
	}
	
	//Pre: name != null && hasContact(name)
	public void setPhone(String name, int phone) {
		Contact contact = findContact(name);
		
		if (contact == null) {
			throw new ContactDoesNotExistException();
		}
		contact.setPhone(phone);
	}
	
	//Pre: name != null && hasContact(name)
	public void setEmail(String name, String email) {
		Contact contact = findContact(name);
		
		if (contact == null) {
			throw new ContactDoesNotExistException();
		}
		contact.setEmail(email);
	}
	
	public Iterator<Contact> getContactIterator() {
		return contacts.iterator();
	}
	
	public String getName(int phone) {
		Contact contact = findContact(phone);
		
		if (contact == null) {
			throw new PhoneDoesNotExistException();
		}
		return contact.getName();
	}

	public Boolean equalContacts() {
		Set<Integer> visitedPhones = new HashSet<>();
		
		for (Contact contact: contacts) {
			if (visitedPhones.contains(contact.getPhone())) {
				return true;
			}
			visitedPhones.add(contact.getPhone());
		}
		return false;
	}
}
