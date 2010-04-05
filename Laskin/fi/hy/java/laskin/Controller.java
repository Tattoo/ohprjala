package fi.hy.java.laskin;

import java.awt.event.ActionEvent;

public interface Controller {

	/**
	 * Gives this controller access to the view that is calling this controller
	 * @param view
	 */
	public void assignView(View view);
	
	//	public void assignModel(Model model);
	
	/**
	 * Processess an UI event. Performs actions and updates output (if any).
	 * @param e
	 */
	public void process(ActionEvent e);
	
}
