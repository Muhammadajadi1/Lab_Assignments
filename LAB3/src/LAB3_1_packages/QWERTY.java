
package LAB3_1_packages;

import java.util.ArrayList;

public class QWERTY extends Keyboard {

	/*
	 * Constructor
	 */
	public QWERTY() {

		buttonCodeList = new ArrayList<String>(){{
			for(int i = 1; i <= 39; i++){
				add("" + i);
			}
		}};

		buttonValueList = new ArrayList<String>(){{
			add("" + Keyboard.SpecialButtons.Backspace);
			add("" + Keyboard.SpecialButtons.Space);
			add("" + Keyboard.SpecialButtons.Enter);
			add("a");add("b");add("c");add("d");add("e");add("f");
			add("g");add("h");add("i");add("j");add("k");add("l");
			add("m");add("n");add("o");add("p");add("q");add("r");
			add("s");add("t");add("u");add("v");add("w");add("x");
			add("y");add("z");

			for(int num = 0; num <= 9; num++) {
				add("" + num);
			}
		}};

		super.showKeyboard(10, 10);
	}
}

