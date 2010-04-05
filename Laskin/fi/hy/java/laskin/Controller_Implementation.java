package fi.hy.java.laskin;

public class Controller_Implementation implements Controller {

	private static final long	serialVersionUID	= 8393096071539802563L;
	private View view;
	
	@Override
	public void assignView(View view) {
		this.view = view;
	}
	
}
