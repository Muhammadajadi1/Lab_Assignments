package lab4_Exception;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import lab4_Exception_OS.OperatingSystem.*;




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

		public void buttonPressed(String newBtnCode) throws OSTaskException, IOException{
			String value = getButtonValue(newBtnCode);
			if(value != null){

			int index = Integer.parseInt(newBtnCode);
			KeyboardButton button = buttons.get(index-1);

            if (button instanceof NamedButtons) {
                	displayedText += ((NamedButtons) button).getAction();
            }

            else if (button instanceof SpecailActionButton) {
            	try {
                	displayedText += ((SpecailActionButton) button).act(value, displayedText);
            	}

            	catch(OSTaskException ex){
            		Scanner input1 = new Scanner(System.in);
            		System.out.println("Keybaord: Please enter the file path: ");
            		String path = input1.nextLine();
            		System.out.println("OS: I will handle this ");

            		if(ex.getOperation().equals("Load")) {

            			System.out.println("*********** Loaded **********");
            			String content = getLoadedContent(path);
            			System.out.println(content);
            			System.out.println("*********** DONE **********");
            			addLoadedContent(content);

            		}

            		else {
            			saveContent(path, displayedText);
            			System.out.println("writing...");
            			System.out.println("*********** Saved **********");
            			System.out.println(displayedText);
            			System.out.println("*********** DONE **********");
            			displayedText = "";
            		}

            	}
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

		protected void addLoadedContent(String content){

			System.out.println("Keyboard: what do you want to do with the new text :");
			System.out.println("1-append.");
			System.out.println("2-replace.");
			System.out.println("3-ignore.");

			Scanner input = new Scanner(System.in);
			String choice = input.nextLine();

			switch(choice){
			case "1":
				displayedText += content;
				break;

			case "2":
				displayedText = content;
				break;

			case "3":
				break;

				default:
					System.out.println("That was a wrong choice!");
			}
		}

		private void saveContent(String path, String content) throws IOException {
			path += ".txt";
			PrintWriter writeContent = null;

			try {
				File file = new File(path);
				writeContent = new PrintWriter(file);
				writeContent.write(content);
			}

			catch(IOException ex1) {
				ex1.printStackTrace();
			}

			finally{
				if(writeContent != null)
					writeContent.close();
			}
		}

		private String getLoadedContent(String path) throws IOException {
			path += ".txt";
			try {
			Scanner read = new Scanner(new File(path));
			String content = read.nextLine();
			read.close();
			return content;
			}
			catch(FileNotFoundException ex2){
				return "This file does not exist! enter a valid path";
			}
		}

	}

