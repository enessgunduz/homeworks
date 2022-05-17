import java.util.*;
public class HW4_150120038_P2 {
	
	//Muhammed Enes Gündüz - 150120038
	//Purpose : Write a program that will determine whether or not it is valid per the Luhn formula. The Luhn
	//algorithm is a simple checksum formula used to validate a variety of identification numbers, such
	//as credit card numbers. 
	//How to : The first step of the Luhn algorithm is to double every second digit, starting from the right.
	//If doubling the number results in a number greater than 9 then subtract 9 from the product.
	//Then, calculate the sum all of the digits. If the sum is evenly divisible by 10, then the number is valid.

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); //A scanner for all inputs
		
		String number = input.nextLine(); //taking number from user
		String cleanedNumber = "";
		for (int i = 0; i < number.length(); i++) {
			if((!(Character.isDigit(number.charAt(i))) && !(number.charAt(i) == ' ')) || number.length()<2) { //check if number is valid or not
				System.out.println("Invalid Input !");
				System.exit(0); //exit if it is not valid
			}	
			
			if(number.charAt(i) != ' ') {
				cleanedNumber+=number.charAt(i); //create cleaned number
				
			} 		
		}
		
		System.out.println(validateNumber(cleanedNumber) ? "Number is Valid" : "Number is Invalid"); //print if number is valid or not

	}
	
	public static boolean validateNumber (String number) {
		boolean isEven = false;
		int total = 0;
		String dNumber = "";
		String lNumber = "";
		if(number.length()%2==0) {
			isEven = true; //if number is even, make isEven true
		}
		
		int valueOfChar = 0;
		for (int i = 0; i < number.length(); i++) {
			valueOfChar = number.charAt(i) - '0'; //take the value of char
			if(isEven && i%2==0) {
				dNumber +=number.charAt(i); //if number and i is even, add current number to dNumber
				if(valueOfChar*2<9) {
					valueOfChar*=2;
					lNumber += valueOfChar; //lNumber will be sum of valueOfChar
				} else {
					valueOfChar = (valueOfChar*2) - 9;
					lNumber += valueOfChar; //lNumber will be sum of valueOfChar
				}
			} else if(isEven && i%2!=0) {
				dNumber += "_"; //if number is even and i is not, add current number to dNumber
				lNumber += number.charAt(i); //lNumber will be sum of valueOfChar
			} else if(!isEven && i%2==0) {
				dNumber += "_"; //if number is not even and i is even, add current number to dNumber
				lNumber += number.charAt(i); //lNumber will be sum of valueOfChar
			} else if(!isEven && i%2!=0) {
				dNumber +=number.charAt(i); //if number and i is not even, add current number to dNumber
				if(valueOfChar*2<9) {
					valueOfChar*=2;
					lNumber += valueOfChar; //lNumber will be sum of valueOfChar
				} else {
					valueOfChar = (valueOfChar*2) - 9;
					lNumber += valueOfChar; //lNumber will be sum of valueOfChar
				}
			}
			
			total += valueOfChar; //total will be sum of all values
		}
		
		System.out.println("DNumber:"+dNumber+"\nLNumber:"+lNumber); 
		return total%10==0; //return if total is divisible 10 or not
		
	}


}
