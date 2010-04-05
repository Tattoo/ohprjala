package fi.hy.java.laskin;

import java.awt.event.ActionEvent;

public class Controller_Implementation implements Controller {

	private static final long	serialVersionUID	= 8393096071539802563L;
	private View view;
	private String outputContents;
	
	@Override
	public void assignView(View view) {
		this.view = view;
	}
	
	public void process(ActionEvent e) {
		// TODO calls to model
		view.setOutput(outputContents);
	}
	
}
