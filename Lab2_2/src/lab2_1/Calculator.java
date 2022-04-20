package lab2_1;

import java.util.ArrayList;

public class Calculator extends Keyboard {

	/*
	 * Constructor
	 */

	public Calculator() {

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
			add("" + Keyboard.SpecialButtons.Backspace);
			add("" + Keyboard.SpecialButtons.Space);
			add("" + Keyboard.SpecialButtons.Enter);
		}};
	}

	/*
	 * Methods
	 */

	@Override
	public void buttonPressed(String buttoncode) {

		int index = super.getButtonCodeIndex(buttoncode);

		if (index != -1){
			String str = super.getAllButtonsValue().get(index);
			if("=".equals(str)){
				String[] str2 = super.getDisplayedText().split("\n");

				int result = EvaluateString.evaluate(str2[str2.length - 1]);
				super.addToDisplayedText(" = " + result + "\n");
			}

			else
			{super.buttonPressed(buttoncode);}

		}

	}
}

