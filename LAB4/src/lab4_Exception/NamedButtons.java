package lab4_Exception;

public class NamedButtons  extends KeyboardButton {
	private String action;


	public NamedButtons(String buttons, int codes, String action) {
		super(buttons, codes);
		setAction(action);
	}


	public void setAction(String newAction) {
		action = newAction;

	}

	public String getAction(){return action;}

	@Override
	public String toString(){return "NamedButton{" + "action='" +
	action + '\'' + "}";}



}
