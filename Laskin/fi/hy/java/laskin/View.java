package fi.hy.java.laskin;

public interface View {
	
	public void assignController(Controller controller);
	public void setVisible();
	public void setOutput(String output);
}
