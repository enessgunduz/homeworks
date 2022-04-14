import java.util.*;

public class HW1_150120038_P1 {

	public static void main(String[] args) {
		
		//Muhammed Enes Gündüz - 150120038
		//Purpose : The purpose is, find the cost of all the travel and show it to the user.
		//How to : take the distance, miles per gallon and price per gallon. Then, calculate the cost.
		
		
		Scanner input = new Scanner(System.in); //A scanner for all the inputs
		
		System.out.print("Enter the driving distance: ");
		double distance = input.nextDouble();
		System.out.print("Enter miles per gallon: ");
		double milesPerGallon = input.nextDouble();
		System.out.print("Enter price per gallon: ");
		double pricePerGallon = input.nextDouble();
		
		double cost = (distance/milesPerGallon)*pricePerGallon; //Calculating the cost
		cost = (int)(cost*100)/100.0; //Getting rid of other digits by multiplying with 100, type casting and dividing by 100.0. We need only 2 digits after the decimal point.
		System.out.print("The cost of driving is $"+cost);

	}

}
