package LAB3_1_packages;

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

	protected void showKeyboard(int rows, int cols){
		TableViewer table = new TableViewer(getAllButtonsCode(),getAllButtonsValue());
		table.viewTable(rows, cols);
	}

	protected int getButtonCodeIndex(String buttoncode){

		return buttonCodeList.indexOf(buttoncode);
	}

	public void buttonPressed(String newBtnCode){
		int index = getButtonCodeIndex(newBtnCode);

		if (index != -1){

			String str = getAllButtonsValue().get(index);

			if("Backspace".equals(str)){ backspace();}
			else if("Space".equals(str)){ space();}
			else if("Enter".equals(str)){ newLine();}
			else
				{addToDisplayedText(str);}
		}

		System.out.println(("Text entered: \n" + "-----------------------------------") );
		System.out.println(getDisplayedText());
		System.out.println("-----------------------------------");

	}

	protected void backspace(){
		int textLen = getDisplayedText().length();
		if(textLen > 0) {
		String str = getDisplayedText();
		displayedText = str.substring(0, str.length() - 1);
//		addToDisplayedText("\b");
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
