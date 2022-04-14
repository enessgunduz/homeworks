import java.util.Scanner;

public class HW2_150120038_P3 {

	public static void main(String[] args) {
		
		//Muhammed Enes Gündüz - 150120038
		//Purpose : The purpose is, find the tax amount and tax rate by using the year and income information which comes from user
		//How to : Take the year and income values from user. Check whether year and income are in range or not. Categorize if-else
		//statements by years and income amount. Then calculate the tax and real tax rate and print all the information.


		
		Scanner input = new Scanner(System.in); //A scanner for all inputs
		
		int year = input.nextInt(); //taking year and income values
		double income = input.nextDouble();
		
		if (year<2017 || year>2020) {
			System.out.println("Undefined year value");
			System.exit(1);                             //Checking whether year and income are in range or not
		} else if(income<=0) {
			System.out.println("Income must be > 0");
			System.exit(1); //If not, exiting from program.
		}
		
		double taxAmount = 0; //Defining tax amount
		
		if(year == 2017) { //Categorizing the years  in different if statements
			if(income<13000) { //Checking the amount of income is less or more than the constant
				taxAmount = income*(15.0/100); //Setting the amount of taxAmount by tax rate.
			} else if (income<30000) {         // Those 3 explains are valid in all if-else's.
				taxAmount = 1950 + (income - 13000)*(20.0/100);
			} else if (income<110000) {
				taxAmount = 5350 + (income - 30000)*(27.0/100);
			} else if (income>=110000) {
				taxAmount = 26950 + (income - 110000)*(35.0/100);
			}
		} else if (year == 2018) {
			if(income<14800) {
				taxAmount = income*(15.0/100);
			} else if (income<34000) {
				taxAmount = 2220 + (income - 14800)*(20.0/100);
			} else if (income<120000) {
				taxAmount = 6060 + (income - 34000)*(27.0/100);
			} else if (income>=120000) {
				taxAmount = 29280 + (income - 120000)*(35.0/100);
			}
		} else if (year == 2019) {
			if(income<18000) {
				taxAmount = income*(15.0/100);
			} else if (income<40000) {
				taxAmount = 2700 + (income - 18000)*(20.0/100);
			} else if (income<148000) {
				taxAmount = 7100 + (income - 40000)*(27.0/100);
			} else if (income<500000) {
				taxAmount = 36260 + (income - 148000)*(35.0/100);
			} else if (income>=500000) {
				taxAmount = 159460 + (income - 500000)*(40.0/100);
			}
		} else if (year == 2020) {
			if(income<22000) {
				taxAmount = income*(15.0/100);
			} else if (income<49000) {
				taxAmount = 3300 + (income - 22000)*(20.0/100);
			} else if (income<180000) {
				taxAmount = 8700 + (income - 49000)*(27.0/100);
			} else if (income<600000) {
				taxAmount = 44070 + (income - 180000)*(35.0/100);
			} else if (income>=600000) {
				taxAmount = 191070 + (income - 600000)*(40.0/100);
			}
		}
		
		double realTaxRate = taxAmount/income; //Calculating real tax rate and income after tax.
		double incomeAfterTax = income-taxAmount; 
		
		realTaxRate = (int)(realTaxRate*10000)/100.0;
		taxAmount = (int)(taxAmount*100)/100.0; //Getting rid of other digits by multiplying with 100, type casting and dividing by 100.0. 
		incomeAfterTax = (int)(incomeAfterTax*100)/100.0; //We need only 2 digits after the decimal point.
		
		System.out.println("Income: "+income);
		System.out.println("Tax amount: "+taxAmount); //Printing the values that we found.
		System.out.println("Income after tax: "+incomeAfterTax);
		System.out.println("Real tax rate: "+realTaxRate+"%");
	}

}
