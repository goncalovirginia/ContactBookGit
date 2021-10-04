package contactBook;

public interface Contact {
	
	String getName();
	
	int getPhone();
	
	String getEmail();
	
	void setPhone(int phone);
	
	void setEmail(String email);
	
	boolean equals(Contact otherContact);
	
}
