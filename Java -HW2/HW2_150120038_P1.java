import java.util.Scanner;

public class HW2_150120038_P1 {

	public static void main(String[] args) {
		
		//Muhammed Enes Gündüz - 150120038
		//Purpose : The purpose is, check the last character of the ISBN-10 number which's first 9 digits comes from user and promt it.
		//How to : take the number from user, take each digit from the number and assign it to different variables. 
		//Then calculate checksum and check whether checksum is 10 or not and set the last digit. Then, print the new number.
		
		Scanner input = new Scanner(System.in); //A scanner for taking the number
		
		System.out.print("Enter the first 9 digits of an ISBN as integer: ");
		int number = input.nextInt(); //taking the number from user
		
		int I = number%10;
		number /=10;
		int H = number%10;
		number /=10;
		int G = number%10;
		number /=10;
		int F = number%10;
		number /=10;
		int E = number%10;    //Assigning the digits to different variables by using reminder operator
		number /=10;		  //and taking used digits out by using integer division.
		int D = number%10;
		number /=10;
		int C = number%10;
		number /=10;
		int B = number%10;
		number /=10;
		int A = number%10;
		
		char lastDigit; //Declaring lastDigit character
			
		int checkSum = (A*1+B*2+C*3+D*4+E*5+F*6+G*7+H*8+I*9)%11; //Calculating checksum
		
		if(checkSum == 10) { //Checking whether checkSum is 10 or not
			lastDigit = 'X'; //If it is 10, lastDigit will be X
		} else {
			lastDigit = (char)(checkSum + '0'); //If it is not, lastDigit will be the checksum. If we add checkSum '0', it 
		}										//will become the value of checkSum in ASCII.
		
		System.out.print("The ISBN-10 number is "+ A+B+C+D+E+F+G+H+I+lastDigit); //Printing the result
		
		
	}

}
