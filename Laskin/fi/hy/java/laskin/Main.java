package fi.hy.java.laskin;

/**
 * Main method for a Calculator
 * @author ohprjala, Ohjelmistoprosessit ja laatu -kurssin harjoitustyöryhmä 
 */
public class Main {
	
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	View view = new View_Implementation();
            	Controller controller = new Controller_Implementation();
            	view.assignController(controller);
            	controller.assignView(view);
            	// TODO create model
            	// TODO give model to controller
            	view.setVisible();
            }
        });
    }
    
}
