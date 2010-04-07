package fi.hy.laskin.main;

import java.awt.event.ActionEvent;

public interface Controller {

	/**
	 * Gives this controller access to the view that is calling this controller
	 * @param view
	 */
	public void assignView(View view);
	
	/**
	 * Gives this controller the calculator that is to be used in performing functions
	 * @param calculator
	 */
	public void assignModel(Calculator calculator);
	
	/**
	 * Processess an UI event. Performs actions and updates output (if any).
	 * @param e
	 */
	public void process(ActionEvent e);
	
}
