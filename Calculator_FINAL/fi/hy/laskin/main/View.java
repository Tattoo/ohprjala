package fi.hy.laskin.main;

import java.util.Map;

public interface View {

	/**
	 * Assigns a controller to be used by this view
	 * 
	 * @param controller
	 */
	public void assignController(Controller controller);

	/**
	 * Sets this view visible. Is called once afrer initialization of the
	 * program is done. Before calling this method the view should not be
	 * visible to the user.
	 */
	public void setVisible();

	/**
	 * Updates the output
	 * 
	 * @param output
	 */
	public void setOutput(String output);

	/**
	 * Updates memory values
	 * @param memory
	 */
	public void setMemory(Map<Integer, Double> memory);
	
	/**
	 * Opens a dialog telling that a file with the given filename has been
	 * created
	 * 
	 * @param filename
	 */
	public void fileCreated(String filename);

}
