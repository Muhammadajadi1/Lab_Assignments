	/**Calculating fraction addition
		 * Author: Muhammad Ajadi
		 * VERsion 1.0
		 * */
public class Fraction1 {
	
	public static double fraction_addition(int num1, int denum1, int num2, int denum2) {
		
		
		return ((double)(num1/denum1)) + ((double)(num2/denum2));
	}
	
		/** The main method used for calling the fraction method */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print((double)fraction_addition(5,6,4,9));
	}

}
