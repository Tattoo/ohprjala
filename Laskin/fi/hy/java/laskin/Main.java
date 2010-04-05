package fi.hy.java.laskin;

public class Main {
	
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	View view = new View_Implementation();
            	Controller controller = new Controller_Implementation();
            	view.assignController(controller);
            	controller.assignView(view);
            	view.setVisible();
            }
        });
    }
    
}
