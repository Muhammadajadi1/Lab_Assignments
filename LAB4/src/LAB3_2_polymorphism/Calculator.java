package LAB3_2_polymorphism;

import java.util.EmptyStackException;

import LAB3_2_polymorphism_OS.OperatingSystem.*;
//import LAB3_2_polymorphism_OS.OperatingSystem.SpecialButtons;

public class Calculator extends Keyboard {

	/*
	 * Constructor
	 */

	public Calculator (int firstCode, String[] keyboardButtonsValues, String[] generalButtonsValues,
			String[] generalButtonsActions, SpecialButtons[] SpecialButtonsList)
{
	super(firstCode, keyboardButtonsValues, generalButtonsValues,
						generalButtonsActions, SpecialButtonsList);
	super.showKeyboard(10, 10);

}
	/*
	 * Methods
	 */

	@Override
	public void buttonPressed(String buttoncode) {

		int index = Integer.parseInt(buttoncode);

		if (index != -1){
			String str = super.getAllButtonsValue().get(index);
			if("=".equals(str)){
				String[] str2 = super.getDisplayedText().split("\n");
				try {
					int result = EvaluateString.evaluate(str2[str2.length - 1]);
					super.displayedText += (" = " + result + "\n");
					super.showDisplayedText();
				}

				catch(UnsupportedOperationException ex){
					System.out.println("****Unacceptable expression! I will delete it****");
					super.displayedText = "";
				}

				catch(EmptyStackException ex){
					System.out.println("***Invalid expression!, Re-enter correct one***");

				}
			}

			else
			{super.buttonPressed(Integer.toString(index + 1));}

		}

	}
}

