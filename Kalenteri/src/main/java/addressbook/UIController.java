package main.java.addressbook;

import javax.swing.event.TableModelEvent;
import java.awt.event.ActionEvent;
import java.util.*;

public class UIController {
	
	private static final int FIRST_ROW = 0;
	private static final int COLUMNS = 4;
	private static final int LASTNAME = 0;
	private static final int FIRSTNAME = 1;
	private static final int ADDRESS = 2;
	private static final int PHONE = 3;
	private UI ui;
	private AddressBook addressBook;
	  
	public UIController(UI ui, AddressBook addressBook) {
		this.ui = ui;
		this.addressBook = addressBook;
	}
	
	public void initialize() {
		ui.setController(this);
	}
	
	public void searchFieldEvent(ActionEvent e) {
		// itse toteutus
	}
	
	public void contactTableEvent(TableModelEvent e) {
		int editedRow = e.getFirstRow();
		
		if (editedRow == FIRST_ROW) {
			addContact(editedRow);
		} else {
			switch (e.getType()) {
			case TableModelEvent.INSERT:
				break;
			case TableModelEvent.UPDATE:
				break;
			case TableModelEvent.DELETE:
				break;
			}
		}
		updateTableModel();
	}
	
	private void updateTableModel() {
		Set<Contact> contacts = addressBook.find("");
		String [][] tableModel = new String[contacts.size()+1][COLUMNS];
		int row = 1;
		for (Contact c : contacts) {
			tableModel[row][0] = c.lastname();
			tableModel[row][1] = c.firstname();
			tableModel[row][2] = c.address();
			tableModel[row][3] = c.phone();
			row++;
		}
		ui.setContactTable(tableModel);
	}

	private void addContact(int editedRow) {
		String lastname  = ui.getContactTableValue(editedRow, LASTNAME);
		String firstname = ui.getContactTableValue(editedRow, FIRSTNAME);
		String address   = ui.getContactTableValue(editedRow, ADDRESS);
		String phone     = ui.getContactTableValue(editedRow, PHONE);
		addressBook.addContact(lastname, firstname, address, phone);
	}
	
	/*
	private void updateContact(int editedRow) {
		String lastname  = ui.getContactTableValue(editedRow, LASTNAME);
		String firstname = ui.getContactTableValue(editedRow, FIRSTNAME);
		String address   = ui.getContactTableValue(editedRow, ADDRESS);
		String phone     = ui.getContactTableValue(editedRow, PHONE);
		addressBook.addContact(lastname, firstname, address, phone);
	}
	*/
	
}
