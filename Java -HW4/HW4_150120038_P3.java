import java.util.*;
public class HW4_150120038_P3 {
	
	//Muhammed Enes Gündüz - 150120038
	//Purpose : Write a program that takes an input letter and outputs it in a diamond shape. Given a letter, it
	//prints a diamond starting with 'A', with the supplied letter at the widest point.
	//How to : I will write 2 different methods, first one will be construct the diamond and second one will be print it
	//The first row contains one 'A'. The last row contains one 'A'. All rows, except the first and last, have exactly two identical letters.

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); //An scanner for all inputs
		System.out.print("Enter a Letter: ");
		String stringLetter = input.next(); //taking letter from user
		char letter = 'A';
		
		if(stringLetter.length() == 1) {
			letter = stringLetter.charAt(0);
			if(letter>='a' && letter<='z') {
				letter-=32; //if letter is small case, make it uppercase
			}
			if(letter>'Z' || letter<'A') {
				System.out.println("Invalid Input !"); //if letter is not between A and Z, finish the program
				System.exit(0);
			}
			
		} else {
			System.out.println("Invalid Input !");
			System.exit(0);
		}
		
		printDiamond(constructDiamond(letter)); //print the diamond by invoking methods

	}
	
	public static char[][] constructDiamond (char letter){
		int rowOrCol = ((letter - 'A')*2)+1; //total row amount
		char[][] diamond = new char[rowOrCol][rowOrCol]; //the array which will be returned
		
		for (int i = 0; i <= (letter-'A'); i++) {
			for (int j = 0; j < rowOrCol; j++) {
				if(i+j == letter-'A') {
					diamond[i][j] = (char)('A'+i); //feed the array if the letter is in right spot
				} else if(i+j==letter-'A'+2*i) {
					diamond[i][j] = (char)('A'+i); //feed the array if the letter is in right spot
				} else {
					diamond[i][j] = '.'; //feed the array by . if none of above is true
				}
			}
			
		}
		
		for (int i = (letter-'A')-1; i >=0; i--) { //This loop is nearly same as up one, it will be downside of diamond
			for (int j = rowOrCol-1; j >=0 ; j--) {
				if(i+j == letter-'A') {
					diamond[i][j] = (char)('A'+i); //feed the array if the letter is in right spot
				} else if(i+j==letter-'A'+2*i) {
					diamond[i][j] = (char)('A'+i); //feed the array if the letter is in right spot
				} else {
					diamond[i][j] = '.'; //feed the array by . if none of above is true
				}
			}
			
		}
		
		return diamond;
		
	}
	
	public static void printDiamond (char[][] diamond) {
		for (int i = 0; i < diamond.length-(diamond.length/2); i++) {
			for (int j = 0; j < diamond[i].length; j++) { 
				System.out.print(diamond[i][j]); //printing the upside of diamond
			}
			System.out.println();
		}
		for (int i = (diamond.length/2)-1; i >= 0; i--) {
			for (int j = diamond.length-1; j >= 0; j--) {
				System.out.print(diamond[i][j]); //printing the downside of diamond
			}
			System.out.println();
		}
	}

}
