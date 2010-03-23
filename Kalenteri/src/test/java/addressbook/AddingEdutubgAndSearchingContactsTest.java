package test.java.addressbook;

import junit.framework.*;
import main.java.addressbook.*; 
import java.util.Set;
import java.util.Iterator;

public class AddingEdutubgAndSearchingContactsTest {

	public static Test suite() {
		return new TestSuite(AddingEdutubgAndSearchingContactsTest.class.getDeclaredClasses());
	}

	public static class Can_create_new_contacts_and_find_them extends TestCase {
		
		private AddressBook addressBook;
		
		protected void setUp() {
			addressBook = new AddressBook(new MemoryStorageForContactDatabase());
			addressBook.addContact("Piirainen", "Esko",       "",      "0505050");
			addressBook.addContact("Piirainen", "Esko Olavi", "",      "444 111111");
			addressBook.addContact("Kähkylä",   "Keijo",     "Enterinkuja", "");
			addressBook.addContact("",          "Masa",      "",       "en tiedä");
		}
		
		public void test_that_added_contacts_are_found_by_last_name() {
			Set<Contact> results = addressBook.find("Piirainen");
			assertEquals(results.size(), 2);
			Iterator<Contact> i = results.iterator();
			Contact c = i.next();
			assertEquals(c.lastname(), "Piirainen");
		}
		
		public void test_that_added_contacts_are_found_by_partial_last_name() {
			Set<Contact> results = addressBook.find("Piirai");
			assertEquals(results.size(), 2);
			Iterator<Contact> i = results.iterator();
			Contact c = i.next();
			assertEquals(c.lastname(), "Piirainen");
		}
		
		public void test_that_added_contacts_are_found_by_case_insensitive_last_name() {
			Set<Contact> results = addressBook.find("kähkylä");
			assertEquals(results.size(), 1);
			Iterator<Contact> i = results.iterator();
			Contact c = i.next();
			assertEquals(c.lastname(), "Kähkylä");
		}
		
		public void test_that_added_contacs_are_found_by_other_fields() {
			Set<Contact> results = addressBook.find("E");
			assertEquals(results.size(), 4);
		}
		 
		public void test_that_all_are_found_with_empty_search_word() {
			Set<Contact> results = addressBook.find(""); 
			assertEquals(results.size(), 4);
		}
		
	}
	
	
	
	
	
}
