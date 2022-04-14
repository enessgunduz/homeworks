import java.util.Scanner;

public class HW2_150120038_P2 {

	public static void main(String[] args) {
		
		//Muhammed Enes Gündüz - 150120038
		//Purpose : The purpose is, find the day of week by using Zeller’s congruence and the user data. Formula in below.
		//How to : Take the year, month and the day of the month from user and put them into the formula below. Then calculate
		//the day of week and promt the day's name to user. Check whether month is 1 or 2, if it is, then change the month and the year.
		
		
		//d = (f + (26*(m+1)/10) + y + (y/4) + (c/4) + 5*c) %7
		//d -> day of the week (0 to 6)    m -> month (3: March ... 12: December, (13: January, 14: February will count in previous year)
		//f -> day of the month            c -> century          y-> year of the century
		
		Scanner input = new Scanner(System.in); //A scanner for all inputs

		
		System.out.print("Enter year (e.g. 2012): ");
		int year = input.nextInt(); 
		System.out.print("Enter month (e.g. 1-12): "); //Taking values from user and holding them in variables.
		int month = input.nextInt();
		System.out.print("Enter the day of the month (e.g. 1-31): ");
		int dayOfMonth = input.nextInt();
		
		if (month == 1) {
			month = 13;
			year--;  //Checking whether month is 1 or 2 and setting the month and the year for algorithm.
		} else if(month == 2) {
			month = 14;
			year--;
		}
		
		
		int century = (year/100); //Calculating century and year of century
		int yearOfCentury = year%100;
				
		int dayOfWeek = (dayOfMonth + (26*(month+1)/10) + yearOfCentury + (yearOfCentury/4) + (century/4) + (5*century))%7; 
		//Calculating day of week by using formula in line 13
		
		String nameOfDay = ""; //Declaring a string to keep the name of the day
		
		switch(dayOfWeek) { //Setting the day from integer to name of the day by using switch-case.
			case 0:
				nameOfDay = "Saturday";
				break;
			case 1:
				nameOfDay = "Sunday";
				break;
			case 2:
				nameOfDay = "Monday";
				break;
			case 3:
				nameOfDay = "Tuesday";
				break;
			case 4:
				nameOfDay = "Wednesday";
				break;
			case 5:
				nameOfDay = "Thursday";
				break;
			case 6:
				nameOfDay = "Friday";
				break;
		}
		
		System.out.println("Day of the week is "+nameOfDay); //Printing the result
		
		
	}

}
