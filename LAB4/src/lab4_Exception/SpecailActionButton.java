package lab4_Exception;

import lab4_Exception_OS.OperatingSystem.SpecialButtons;

public class SpecailActionButton extends KeyboardButton {

	private SpecialButtons buttonType;

	public SpecailActionButton(SpecialButtons btn, int code){

		super(btn.name(), code);

		buttonType = btn;
	}

	public String act (String value, String text) throws OSTaskException {
		if(buttonType.name().equals(value)){
			switch(value){

			case "Load":
				throw new OSTaskException(text, value);

			case "Save":
				throw new OSTaskException(text, value);

			default:
				return backSpace(value);
			}

		}
		return"##This button has no specialty##";
	}

	private String backSpace(String value){
		return "\b";
	}
}
