package LAB3_2_polymorphism_OS;

import java.util.Scanner;

import LAB3_2_polymorphism.Calculator;
import LAB3_2_polymorphism.Keyboard;
import LAB3_2_polymorphism.QWERTY;

public class OperatingSystem {
	//General buttons value that should be in every keyboard
	public enum SpecialButtons { Backspace };

	public static void main(String[] args) {

	Scanner input = new Scanner(System.in);
	//initiate the values of the buttons
	String[] qwertyButtonsValues = {"a","b","c","d","e","f","g","h","i",
										"j","k","l","m","n","o","p","q","r",
										"s","t","u","v","w","x","y","z",
										"0","1","2","3","4","5","6","7","8","9"};

	String[] calculatorButtonsValues = {"0","1","2","3","4","5","6","7",
										"8","9","+","-","/","*","=","(",")"};

	//initiate the values of the general buttons
	String[] generalButtonsValues = {"Space","New Line"};
	String[] generalButtonsActions = {" ","\n"};
	

	//initiate the values of the buttons
	SpecialButtons[] SpecialButtonsList = {SpecialButtons.Backspace};

	while(true) {
	//ask the user which keyboard to run
	System.out.println("1-QWERTY");
	System.out.println("2-Claculator");
	System.out.println("Please choose one of the two keyboards to run: ");
	int x = input.nextInt();

	//make the keyboard object.
	Keyboard keyboard;
	if(x==1) keyboard = new QWERTY(1,qwertyButtonsValues,generalButtonsValues,
									generalButtonsActions,SpecialButtonsList);

	else keyboard = new Calculator(0,calculatorButtonsValues,generalButtonsValues,
									generalButtonsActions,SpecialButtonsList);

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
