package main.java.addressbook;

import java.util.Set;

public class AddressBook {
	
	private ContactDatabase db;
	
	public AddressBook(ContactDatabase db) {
		this.db = db;
	}
	
	public void addContact(String lastname, String firstname, String address, String phone) {
		db.add( new Contact(lastname, firstname, address, phone));
	}
	
	public Set<Contact> find(String keyword) {
		if (keyword.equals("")) {
			return db.all();
		}
		return db.find(keyword); 
	}
	
}
