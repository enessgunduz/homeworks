import java.util.*;

public class HW1_150120038_P2 {

	public static void main(String[] args) {
		
		//Muhammed Enes Gündüz - 150120038
		//Purpose : The purpose is, convert days to years, months and days and prompt it to user.
		//How to : Take the number of days, firstly find the count of years, then months, and then days by using integer division.
		
		Scanner input = new Scanner(System.in); //A scanner for taking the count of days
		System.out.print("Number of days: ");
		int allDays = input.nextInt();
		
		int years = allDays/365; //Finding years first, by integer division
		int months = (allDays - years*365)/31; //Then months with remaining days, again by integer division
		int days = allDays - years*365 - months*31; //Then subtracting the years and months from allDays will give us the remaining days.
		
		System.out.print("Year: "+years+", Month: "+months+ ", Day: "+days);
		
		
	}

}
