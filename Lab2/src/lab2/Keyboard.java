package lab2;

import java.util.ArrayList;

public class Keyboard {
	/**
	 * Data field
	 */
	private ArrayList<String> buttonCodeList;
	private ArrayList<String> buttonValueList;
	private String displayedText = "";

	// java emun for special button

	public enum SpecialButtons{
		Backspace,
		Space,
		Enter
	}


	/*
	 * Constructor
	 */
	public Keyboard(ArrayList<String> btnCode, ArrayList<String> btnValue) {
		buttonCodeList = btnCode;
		buttonValueList = btnValue;

		if(buttonCodeList.size() == 39) {
			buttonValueList.add(0, "" + SpecialButtons.Backspace);
			buttonValueList.add(1, "" + SpecialButtons.Space);
			buttonValueList.add(2, "" + SpecialButtons.Enter);
		}

		else
		{
			buttonValueList.add("" + SpecialButtons.Backspace);
			buttonValueList.add("" + SpecialButtons.Space);
			buttonValueList.add("" + SpecialButtons.Enter);

		}
	}

	/*
	 * Methods
	 */

	public int getButtonCodeIndex(String buttoncode){

		return buttonCodeList.indexOf(buttoncode);
	}

	public void buttonPressed(String newBtnCode){
		int index = getButtonCodeIndex(newBtnCode);

		if (index != -1){

			String str = getAllButtonsValue().get(index);

			if("Backsapce".equals(getAllButtonsValue().get(index))){ backspace();}
			else if("Space".equals(str)){ space();}
			else if("Enter".equals(str)){ newLine();}
			else
				{addToDisplayedText(str);}
		}

	}

	public void backspace(){
		String str = getDisplayedText();
		displayedText = str.substring(0, str.length() - 1);
	}

	public void space(){addToDisplayedText(" ");}

	public void newLine(){addToDisplayedText("\n");}

	public ArrayList<String> getAllButtonsCode(){return buttonCodeList;}

	public ArrayList<String> getAllButtonsValue(){return buttonValueList;}

	public String getDisplayedText(){return displayedText;}

	public void addToDisplayedText(String newDisplayedText){
		displayedText += newDisplayedText;
	}


}
