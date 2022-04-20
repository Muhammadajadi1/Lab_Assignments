package LAB3_2_polymorphism;

import static LAB3_2_polymorphism_OS.OperatingSystem.*;
//import LAB3_2_polymorphism.Keyboard;

public class SpecailActionButton extends KeyboardButton {

	private SpecialButtons buttonType;

	public SpecailActionButton(SpecialButtons btn, int code){

		super(btn.name(), code);

		buttonType = btn;
	}

	public String act(String value){
		if(buttonType.name().equals(value)){
			return backSpace(value);
		}
		return"##";
	}

	private String backSpace(String value){
		if(buttonType.name().equals(value)){
			return "\b";
		}
		return "##";
	}
}
