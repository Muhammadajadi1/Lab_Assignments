package LAB3_1_packages_OS;

import java.util.Scanner;

import LAB3_1_packages.Calculator;
import LAB3_1_packages.Keyboard;
import LAB3_1_packages.QWERTY;

public class OperatingSystem {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		while(true) {
			//ask the user which keyboard to run
			System.out.println("1-QWERTY");
			System.out.println("2-Claculator");
			System.out.println("Please choose one of the two keyboards to run: ");
			int x = input.nextInt();

			//make the keyboard object.
			Keyboard keyboard;
			if(x==1) keyboard = new QWERTY();
			else keyboard = new Calculator();

			String inputTxt;
			while(true) {
			System.out.print("Please enter the code of the button or -1 to exit: ");
			inputTxt = input.next();
			if(inputTxt.equals(-1+""))break;
			keyboard.buttonPressed(inputTxt);

			}
		}
	}
}
