package lab2_1;

import java.util.Scanner;

public class Testing {
	public static void main(String[] args) {
		//Use this code to test the QWERTY class.
		QWERTY keyboard = new QWERTY();
		TableViewer table = new TableViewer(keyboard.getAllButtonsCode(),keyboard.getAllButtonsValue());

		Scanner input = new Scanner(System.in);
		table.viewTable(10, 10);

		while(true) {
			System.out.print("Please enter the code of the button: ");
			String x = input.next();
			keyboard.buttonPressed(x);
			System.out.println("Texted entered: \n" + "-----------------------------------" );
			System.out.println(keyboard.getDisplayedText());
			System.out.println("-----------------------------------" );
		}

//		//Use this code to test the Calculator class.
//		Calculator keyboard = new Calculator();
//		TableViewer table = new TableViewer(keyboard.getAllButtonsCode(),keyboard.getAllButtonsValue());
//
//		Scanner input = new Scanner(System.in);
//		table.viewTable(10, 10);
//
//		while(true) {
//			System.out.print("Please enter the code of the button: ");
//			String x = input.next();
//			keyboard.buttonPressed(x);
//			System.out.println("Texted entered: \n" + "-----------------------------------" );
//			System.out.println(keyboard.getDisplayedText());
//			System.out.println("-----------------------------------" );
//		}
	}
}

