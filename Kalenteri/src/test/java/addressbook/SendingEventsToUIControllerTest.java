package test.java.addressbook;

import junit.framework.*;
import main.java.addressbook.*; 

import javax.swing.event.TableModelEvent;
import javax.swing.table.*;
import java.awt.event.ActionEvent;
import java.util.*;

public class SendingEventsToUIControllerTest {

	public static Test suite() {
		return new TestSuite(SendingEventsToUIControllerTest.class.getDeclaredClasses());
	}

	public static class X extends TestCase {

		private class MockUI extends UI {
			static final long serialVersionUID = 2L;
			public MockUI() {
			}

			public void setController(UIController controller) {
			}

			public void setContactTable(String [][] contacts) {
			}

			public String getContactTableValue(int row, int column) {
				if (row == 0) {
					switch (column) {
					case 0: return "Lastname";
					case 1: return "Firstname";
					case 2: return "Address";
					case 3: return "Phone";
					}
				}
				return "";
			}
		}

		private UIController controller;
		private AddressBook addressBook;
		private MockUI mockUi;
		private TableModel stubmodel = new DefaultTableModel( new String[1][1], new String[1][1]);

		protected void setUp() {
			addressBook = new AddressBook(new MemoryStorageForContactDatabase());
			mockUi = new MockUI();
			controller = new UIController(mockUi, addressBook);
		} 

		public void test_adding_a_new_user() {
			TableModelEvent e = new TableModelEvent(stubmodel, 0);  
			controller.contactTableEvent(e);
			Set<Contact> results = addressBook.find("Lastname");
			assertEquals(1, results.size());
			Iterator<Contact> i = results.iterator();
			Contact c = i.next();
			assertEquals(c.lastname(), "Lastname");
		}     

	}





}
