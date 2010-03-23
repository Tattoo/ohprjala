package main.java.addressbook;
 
public class Contact {
	
	private String lastname = "";
	private String firstname = "";
	private String address = "";
	private String phone = "";
	
	public Contact(String lastname, String firstname, String address, String phone) {
		this.lastname  = lastname;
		this.firstname = firstname;
		this.address   = address;
		this.phone     = phone;
	}
	
	public String lastname()  { return this.lastname;  }
	public String firstname() { return this.firstname; }
	public String address()   { return this.address;   }
	public String phone()     { return this.phone;     }
	
	public void editLastname(String newValue) {
		this.lastname = newValue;
	}
	public void editFirstname(String newValue) {
		this.firstname = newValue;
	}
	public void editAddress(String newValue) {
		this.address = newValue;
	}
	public void editPhone(String newValue) {
		this.phone = newValue;
	}
	
}
