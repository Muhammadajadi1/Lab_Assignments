package lab4_Exception;

import lab4_Exception_OS.OperatingSystem.*;

//import java.util.ArrayList;

public class QWERTY extends Keyboard {


	public QWERTY(int firstCode, String[] qwertyButtonsValues, String[] generalButtonsValues,
			String[] generalButtonsActions, SpecialButtons[] SpecialButtonsList) {
		// TODO Auto-generated constructor stub
			super(firstCode, qwertyButtonsValues, generalButtonsValues,
					generalButtonsActions, SpecialButtonsList);

				super.showKeyboard(10, 10);
	}
}

