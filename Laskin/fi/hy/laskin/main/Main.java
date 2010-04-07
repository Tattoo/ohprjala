package fi.hy.laskin.main;

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
            	Calculator calculator = new Calculator_Imple();
            	view.assignController(controller);
            	controller.assignView(view);
            	controller.assignModel(calculator);
            	view.setVisible();
            }
        });
    }
    
}
