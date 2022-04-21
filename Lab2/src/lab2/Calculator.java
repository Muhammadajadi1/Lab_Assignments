package lab2;

import java.util.ArrayList;

public class Calculator {
	/*
	 * Data field
	 */
	private Keyboard mainkeyboardObj;
	public ArrayList<String> buttonCodeList;
	public ArrayList<String> buttonValueList;

	/*
	 * Constructor
	 */

	public Calculator(){
		buttonCodeList = new ArrayList<String>(){{
			for(int i = 0; i <= 19; i++){
				add("" + i);
			}
		}};

		buttonValueList = new ArrayList<String>(){{
			for(int i = 0; i <= 9; i++){
				add("" + i);
			}

			add("+");add("-");add("/");add("*");add("=");
			add("(");add(")");
		}};

		mainkeyboardObj = new Keyboard(getAllButtonsCode(),getAllButtonsValue());
	}

	/*
	 * Methods
	 */

	public void buttonPressed(String buttoncode) {

		int index = mainkeyboardObj.getButtonCodeIndex(buttoncode);

		if (index != -1){
			String str = mainkeyboardObj.getAllButtonsValue().get(index);
			if("=".equals(str)){
				String[] str2 = mainkeyboardObj.getDisplayedText().split("\n");

				int result = EvaluateString.evaluate(str2[str2.length - 1]);
				mainkeyboardObj.addToDisplayedText(" = " + result + "\n");
			}

			else
			{mainkeyboardObj.buttonPressed(buttoncode);}

		}

	}

	public String getDisplayedText() {return mainkeyboardObj.getDisplayedText();}

	public ArrayList<String> getAllButtonsValue() {return buttonValueList;}

	public ArrayList<String> getAllButtonsCode() {return buttonCodeList;}
}
