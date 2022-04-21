package lab2;

import java.util.ArrayList;

public class QWERTY {
	/*
	 * Data field
	 */
	private Keyboard mainkeyboardObj;
	private ArrayList<String> buttonValueList;
	private ArrayList<String> buttonCodeList;

	/*
	 * Constructor
	 */
	public QWERTY(){

		buttonCodeList = new ArrayList<String>(){{
			for(int i = 1; i <= 39; i++){
				add("" + i);
			}
		}};

		buttonValueList = new ArrayList<String>(){{

			add("a");add("b");add("c");add("d");add("e");add("f");
			add("g");add("h");add("i");add("j");add("k");add("l");
			add("m");add("n");add("o");add("p");add("q");add("r");
			add("s");add("t");add("u");add("v");add("w");add("x");
			add("y");add("z");

			for(int num = 0; num <= 9; num++) {
				add("" + num);
			}
		}};

		mainkeyboardObj = new Keyboard(getAllButtonsCode(),getAllButtonsValue());
	}

	/*
	 * Methods
	 */

	public void buttonPressed(String btnPressed) {mainkeyboardObj.buttonPressed(btnPressed);}

	public String getDisplayedText() {return mainkeyboardObj.getDisplayedText();}

	public ArrayList<String> getAllButtonsValue() {return buttonValueList;}

	public ArrayList<String> getAllButtonsCode() {return buttonCodeList;}
}
