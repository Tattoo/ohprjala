package test.java.addressbook;

import junit.framework.*;
import main.java.addressbook.*; 

public class ContactCreationAndEditingTest {

	public static Test suite() {
		return new TestSuite(ContactCreationAndEditingTest.class.getDeclaredClasses());
	}

	public static class Can_create_a_new_contact extends TestCase {
		
		private Contact contact;
		
		protected void setUp() {
			contact = new Contact("Piirainen", "Esko", "", "050 5257569");
		}
		
		public void test_setting_contact_info() {
			assertEquals(contact.lastname(),  "Piirainen");
			assertEquals(contact.firstname(), "Esko");
			assertEquals(contact.address(),   "");
			assertEquals(contact.phone(),     "050 5257569");
		}     
		
		public void test_editing_contact_info() {
			contact.editFirstname("Esko Olavi");
			assertEquals(contact.firstname(), "Esko Olavi");
		}
		
	}
	
	
	
	
	
}
