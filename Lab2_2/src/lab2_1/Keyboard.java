package lab2_1;

import java.util.ArrayList;



public class Keyboard {
	/**
	 * Data field
	 */
	protected ArrayList<String> buttonCodeList;
	protected ArrayList<String> buttonValueList;
	protected String displayedText = "";

	// java emun for special button

	protected static enum SpecialButtons{
		Backspace,
		Space,
		Enter
	}


	/*
	 * Constructor
	 */
	public Keyboard(){}

	/*
	 * Methods
	 */

	protected int getButtonCodeIndex(String buttoncode){

		return buttonCodeList.indexOf(buttoncode);
	}

	protected void buttonPressed(String newBtnCode){
		int index = getButtonCodeIndex(newBtnCode);

		if (index != -1){

			String str = getAllButtonsValue().get(index);

			if("Backspace".equals(str)){ backspace();}
			else if("Space".equals(str)){ space();}
			else if("Enter".equals(str)){ newLine();}
			else
				{addToDisplayedText(str);}
		}

	}

	protected void backspace(){
		int textLength = getDisplayedText().length();
		if(textLength > 0) {
		String str = getDisplayedText();
		displayedText = str.substring(0, str.length() - 1);
//		String Str = getDisplayedText();
//		StringBuffer StrBuf = new StringBuffer(Str);
//		displayedText = StrBuf.deleteCharAt(StrBuf.length()-1).toString();
		}
	}

	protected void space(){addToDisplayedText(" ");}

	protected void newLine(){addToDisplayedText("\n");}

	protected ArrayList<String> getAllButtonsCode(){return buttonCodeList;}

	protected ArrayList<String> getAllButtonsValue(){return buttonValueList;}

	protected String getDisplayedText(){return displayedText;}

	protected void addToDisplayedText(String newDisplayedText){
		displayedText += newDisplayedText;
	}


}
