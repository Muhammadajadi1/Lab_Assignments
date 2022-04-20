package LAB3_2_polymorphism;


	import java.util.ArrayList;

	import static LAB3_2_polymorphism_OS.OperatingSystem.*;


	public class Keyboard {
		/**
		 * Data field
		 */
		protected ArrayList<KeyboardButton> buttons = new ArrayList<>();
		protected String displayedText = "";

		/*
		 * Constructor
		 */
		public Keyboard(int firstCode, String[] keyboardButtonsValues, String[] generalButtonsValues,
						String[] generalButtonsActions, SpecialButtons[] SpecialButtonsList)
		{

			int len1 = keyboardButtonsValues.length;
			int len2 = generalButtonsValues.length;
			int len3 = SpecialButtonsList.length;

			if(firstCode == 1){

				for(int i = firstCode; i <= len1; i++){ // To add the Qwerty keyboard
					buttons.add(new KeyboardButton(keyboardButtonsValues[i-1], i));
				}

            for(int j = (firstCode + len1); j <= (len2 + len1); j++) { // To add the general button and action
            		buttons.add(new NamedButtons(generalButtonsValues[j-1-len1], j,
                        generalButtonsActions[j-1-len1]));
            	}

            int length = len1 + len2;
            for(int k = (firstCode + length); k <= (len3 + length); k++) { //To add the Special button
                	buttons.add(new SpecailActionButton(SpecialButtonsList[k-1-length], k));
            	}
			}

		else { //Calculator
            for(int i = firstCode; i < (len1); i++) {
                	buttons.add(new KeyboardButton(keyboardButtonsValues[i], i));
            	}

            for(int j = (firstCode + len1); j < (len2 + len1); j++) {
                	buttons.add(new NamedButtons(generalButtonsValues[j-len1], j,
                        generalButtonsActions[j-len1]));
            	}

            int length = len1 + len2;
            for(int k = (firstCode + length); k < (len3 + length); k++) {
                buttons.add(new SpecailActionButton(SpecialButtonsList[k-length], k));
            }
        }

		}

		/*
		 * Methods
		 */

		protected void showKeyboard(int rows, int cols){
			TableViewer table = new TableViewer(getAllButtonsCode(),getAllButtonsValue());
			table.viewTable(rows, cols);
		}

		protected String getButtonValue(String buttoncode){
			for(KeyboardButton button : buttons){
				if(buttoncode.equals(Integer.toString(button.getCode()))){
					return button.getName();
				}
			}
			return null;
		}

		public void buttonPressed(String newBtnCode){
			String value = getButtonValue(newBtnCode);
			if(value != null){

			int index = Integer.parseInt(newBtnCode);
			KeyboardButton button = buttons.get(index-1);

            if (button instanceof NamedButtons) {
                	displayedText += ((NamedButtons) button).getAction();
            }

            else if (button instanceof SpecailActionButton) {
                	displayedText += ((SpecailActionButton) button).act(value);
            }

            else {
                	displayedText += button.getName();
            	}

            	showDisplayedText();

			}

			 else
		            System.out.println("Not Found!");

		}


		protected ArrayList<String> getAllButtonsCode(){
			return new ArrayList<String>() {{
	            for(KeyboardButton button : buttons) {
	                int code = button.getCode();
	                add("" + Integer.toString(code));
	                }
	        }};
		}

		protected ArrayList<String> getAllButtonsValue(){
			return new ArrayList<String>() {{
	            for(KeyboardButton button : buttons) {
	                String name = button.getName();
	                add("" + name);
	            }
	        }};
		}

		protected String getDisplayedText(){return displayedText;}

		public void showDisplayedText() {

			System.out.println(("Text entered: \n" + "-----------------------------------") );
			System.out.println(getDisplayedText());
			System.out.println("-----------------------------------");
		}


	}

