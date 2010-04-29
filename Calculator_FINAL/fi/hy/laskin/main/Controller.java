package fi.hy.laskin.main;

import java.awt.event.ActionEvent;

public interface Controller {

	/**
	 * Gives this controller access to the view that is calling this controller
	 * 
	 * @param view
	 */
	public void assignView(View view);

	/**
	 * Gives this controller the calculator that is to be used in performing
	 * functions
	 * 
	 * @param calculator
	 */
	public void assignModel(Calculator calculator);

	/**
	 * Gives this controller a result output device
	 * 
	 * @param name
	 * @param outputDevice
	 */
	public void assignResultOutputDevice(String name, OutputDevice outputDevice);

	/**
	 * Gives this controller a sound efects player
	 * 
	 * @param name
	 * @param player
	 */
	public void assignSoundEfectsPlayer(String name, SoundEffectsPlayer player);

	/**
	 * Processess an UI event. Performs actions and updates output (if any).
	 * 
	 * @param e
	 */
	public void process(ActionEvent e);

}
