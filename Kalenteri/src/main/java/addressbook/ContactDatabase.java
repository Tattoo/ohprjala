package main.java.addressbook;

import java.util.Set;

public interface ContactDatabase {
	
	public void add(Contact c);
	
	public Set<Contact> find(String query);
	
	public Set<Contact> all();
	
}
