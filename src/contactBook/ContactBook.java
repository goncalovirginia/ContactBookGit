package contactBook;

import java.util.Iterator;

public interface ContactBook {
	
	int getNumberOfContacts();
	
	void addContact(String name, int phone, String email);
	
	void deleteContact(String name);
	
	int getPhone(String name);
	
	String getEmail(String name);
	
	void setPhone(String name, int phone);
	
	void setEmail(String name, String email);
	
	Iterator<Contact> getContactIterator();
	
	String getName(int phone);
	
	boolean equalContacts();
	
}
