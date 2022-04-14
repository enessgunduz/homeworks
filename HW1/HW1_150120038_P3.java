import java.util.*;

public class HW1_150120038_P3 {

	public static void main(String[] args) {
		//Muhammed Enes G¸nd¸z - 150120038
		//Purpose : The purpose is, calculate the compund monthly interest and show the results to the user .
		//How to : Take the initial principal(p),annual interest rate percentage(r), number of time periods in months(t).
		//Then calculate and show mounthly interest rate percentage(r/12), total compound amount(i) and final balance amount(f) by using 
		//i = f - p and f = p * (1+ (r/1200))^t formulas.
		
		Scanner input = new Scanner(System.in); //A scanner for all the inputs
		
		System.out.print("Enter initial principal amount: ");
		double initialPrincipalAmount = input.nextDouble(); 
		System.out.print("Enter annual interest rate (e.g. 9.45): ");
		double annual›nterestRate = input.nextDouble();
		System.out.print("Enter number of time periods in months: ");
		int numberOfTimePeriods = input.nextInt(); //Taking as an int, because the count of months can't be floating number.
		
		double monthly›nterestRate = annual›nterestRate/12; //Calculating values by using formulas in line-10
		double finalBalanceAmount = initialPrincipalAmount*Math.pow((1+(annual›nterestRate/1200)), numberOfTimePeriods);
		double totalCompound›nterestAmount = finalBalanceAmount - initialPrincipalAmount;
		monthly›nterestRate = (int)(monthly›nterestRate*100)/100.0; //Getting rid of other digits by multiplying with 100, type casting and dividing by 100.0. We need only 2 digits after the decimal point.
		finalBalanceAmount = (int)(finalBalanceAmount*100)/100.0;
		totalCompound›nterestAmount = (int)(totalCompound›nterestAmount*100)/100.0;
		
		System.out.println("Initial principal amount: "+initialPrincipalAmount);
		System.out.println("Monthly interest rate: "+monthly›nterestRate);
		System.out.println("Total compound interest amount: "+totalCompound›nterestAmount);
		System.out.println("Final balance amount: "+finalBalanceAmount);
		
		
		
	}

}
