package main.java.addressbook;

import java.util.*;

public class MemoryStorageForContactDatabase implements ContactDatabase {

	LinkedList<Contact> contacts;
	
	public MemoryStorageForContactDatabase() {
		contacts = new LinkedList<Contact>();
	}
	
	public void add(Contact c) {
		contacts.add(c);
	}
	
	public Set<Contact> find(String query) {
		Set<Contact> results = new HashSet<Contact>();
		for (Contact c : contacts) {
			String[] contactInfo = { c.lastname(), c.firstname(), c.address(), c.phone() };
			if (contains(contactInfo, query))
				results.add(c);
		}
		return results;
	}

	private boolean contains(String[] contactInfo, String query) {
		for (String s : contactInfo) {
			if ( (s.toLowerCase()).startsWith(query.toLowerCase()) ) return true;
		}
		return false;
	}
	
	public Set<Contact> all() {
		Set<Contact> results = new HashSet<Contact>();
		for (Contact c : contacts) results.add(c);
		return results;
	}
}
