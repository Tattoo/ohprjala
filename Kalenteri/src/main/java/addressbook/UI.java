package main.java.addressbook;


public abstract class UI extends javax.swing.JFrame {

		public abstract void setController(UIController controller);
		
		public abstract void setContactTable(String [][] contacts);
		
		public abstract String getContactTableValue(int row, int column);

}
