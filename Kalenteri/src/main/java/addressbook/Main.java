package main.java.addressbook;

public class Main {
	
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	UI_Implementation ui = new UI_Implementation();
            	AddressBook addressBook = new AddressBook(new MemoryStorageForContactDatabase());
            	UIController controller = new UIController(ui, addressBook); 
            	controller.initialize();
            	ui.setVisible(true);
            }
        });
    }
    
}
