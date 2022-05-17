import java.util.*;
public class HW4_150120038_P1 {
	
	//Muhammed Enes Gündüz - 150120038
	//Purpose : The purpose is, make a program that calculates the invoice of each flat in an apartment building
	//How to : there are N flats in a building and apartment heating is the central system. 30% of bill will be
	//shared equally among the flats, the rest 70% will be shared according to the consumption of each
	//flat. I will use 2 different methods, first one will calculate the invoice, other one will print it
	

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); //A scanner for all inputs
		
		
		int totalFlat = input.nextInt(); //taking total flat from user
		double[] flats = new double[totalFlat]; 
		for (int i = 0; i < totalFlat; i++) {
			flats[i] = input.nextDouble(); //taking every flat one by one
		}
		double totalBill = input.nextDouble(); //taking total bill
		
		printBills(calculateTheInvoice(flats, totalBill)); //invoke methods
		
	}
	
	public static double[] calculateTheInvoice (double[] flats, double totalBill) {
		double totalFlat = 0; 
		double[] bills = new double[flats.length]; //create the array which will be returned
		for (int i = 0; i < flats.length; i++) {
			totalFlat+=flats[i]; //calculate total flat
		}
		for (int i = 0; i < flats.length; i++) {
			bills[i] = (flats[i]/totalFlat) * (totalBill*7/10) + (totalBill*3/(10*flats.length)); //fill the bills with respect to the given formula
			bills[i] = (int)(bills[i]*100)/100.0; //take just 2 digits after point
		}
		
		return bills;
	}
	
	public static void printBills (double[] bills) {
		for (int i = 0; i < bills.length; i++) {
			System.out.println("Flat #"+(i+1) +": "+ bills[i]); //print every bill one by one
		}
	}

}
