import java.util.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
public class HW3_150120038_P1 {
	
			//Muhammed Enes Gündüz - 150120038
			//Purpose : The purpose is, print the shape that the vertexes comes from user, in coordinate system.
			//How to : Learn which shape user wants to print, run that shape's function.
			//In functions, take the vertexes from user which must include enough information about that shape. Create coordinate system by using nested for loops
			//Use if-else check by using the geometrical formulas, print *,| or -. 

	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in); //A scanner for all inputs
		
		while(true) { //A loop for keep program running until user inputs 6
			
			System.out.print("1. Line\n2. Triangle\n3. Rectangle\n4. Parabola\n5. Circle\n6. Exit\n");
			
			System.out.print("Select one of the following shapes: ");
			int selectedShape = input.nextInt(); //Take the shape number
			switch(selectedShape) { //Check the number of shape
				case 1:
					LineShape(input); //In all cases except 6, run a function which takes a parameter Scanner.
					break;
				case 2:
					TriangleShape(input);
					break;
				case 3:
					RectangleShape(input);
					break;
				case 4:
					ParabolaShape(input);
					break;
				case 5:
					CircleShape(input);
					break;
				case 6:
					System.exit(0); //If number is 6, exit program
				default:
					System.out.println("Out of range\n"); //Our range is 1 to 6
					
			}
		
		}
		
	}
	
	public static void LineShape(Scanner input) {
		//Equation of line => ax+b = y
		
		//Our logic is just check whether our current point makes equation true or not
		System.out.print("Line formula is y = ax + b\nPlease enter the coefficients a and  b: ");
		int a = input.nextInt(); //2 inputs for the equation
		int b = input.nextInt();
		
		System.out.println("          y");//Printing y at the beginning of axis. 
		
		for (int row = 10; row >= -10; row--) { //Creating Y axis, row will be Y
			for (int col = -10; col <= 10; col++) { //Creating X axis, col will be X
				
				if((a*col)+b == row) { // If current point make the equation true, print *
					System.out.print("*");
				}else if(col == 0) { //Below part will be same in all cases
					System.out.print("|"); //If current point doesn't make the equation true and col equals 0, it means we are on Y axis, printing |
				} else if(row == 0) {
					System.out.print("-"); //If current point doesn't make the equation true and row equals 0, it means we are on X axis, printing -
				} else {
					System.out.print(" "); //If current point doesn't make the equation true and neighter col nor row equals 0, it means we are on nothing, printing space
				}
			}
			if (row == 0) { //Printing x at the ending of axis. 
				System.out.print("x");
			}
			System.out.println(); //Move to the next Y axis line
		}
	
	}
	
	public static void TriangleShape(Scanner input) {
		//Equation of line => (y2-y1)*(x-x2)=(y-y2)*(x2-x1) if vertexes are (x1,y1) and (x2,y2)
		
		//Our logic to print triangle is, thinking like there are 3 lines and they meet in some points.
		
		System.out.print("For triangle, we need the coordinates of the points for three vertices.\nPlease enter the coordinates of 3 vertices a, b, c, d, e, f: ");
		
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		int d = input.nextInt();
		int e = input.nextInt();
		int f = input.nextInt();
		
		int maxY = Max(b, Max(d,f)); //We must check the max and min points of triangle and limit it between them.
		int minY = Min(b, Min(d,f)); //We use Max and Min functions which are written below the code.
		int maxX = Max(a,Max(c,e));
		int minX = Min(a,Min(c,e));
		
		System.out.println("          y");//Printing y at the beginning of axis. 
		
		for (int row = 11; row >= -10; row--) {
			for (int col = -10; col <= 11; col++) {
				
				if(col<=maxX && col >= minX && row <= maxY && row >= minY) { //Limit the triangle between given maxs and mins				
					if((d-b)*(col-c)==(row-d)*(c-a) || (f-d)*(col-e)==(row-f)*(e-c) || (f-b)*(col-e)==(row-f)*(e-a)) { // Using equation in line 76, checking whether current point makes it true or false
						System.out.print("*");
						continue; //If we print *, there is no need to check other conditions
					}					
				}
				if(col == 0) {
					System.out.print("|"); //All same in LineShape
				}  else if(row == 0) {
					System.out.print("-");
				} else {
					System.out.print(" ");
				}
				
			}
			if (row == 0) { //Printing x at the ending of axis. 
				System.out.print("x");
			}
			System.out.println();
		}
		
		
		
	}
	
	public static void RectangleShape(Scanner input) {
		//Distance between 2 point : Math.sqrt(Math.pow((d-b),2) + Math.pow((c-a),2))
		//Equation of line => (y2-y1)*(x-x2)=(y-y2)*(x2-x1) if vertexes are (x1,y1) and (x2,y2)
		
		//Our logic to print Rectangle is, use geometrical equations for finding 4. point and think like there are 4 lines and do all of that after checking whether it is a rectangle or not
		System.out.print("For rectangle, we need the coordinates of the points for three vertices.\nPlease enter the coordinates of 3 vertices a, b, c, d, e, f: ");
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		int d = input.nextInt();
		int e = input.nextInt();
		int f = input.nextInt();
		
		if((Math.pow((d-b),2) + Math.pow((c-a),2)) + (Math.pow((f-b),2) + Math.pow((e-a),2)) != (Math.pow((f-d),2) + Math.pow((e-c),2))){ //We can check if it is rectangle or not by using pisagor theorem.
			System.out.println("You can't draw a rectangle by using these points.");
			System.exit(0); //Exit if it is not a rectangle
		}
		
		int g = e+c-a; //Other point's coordinates, can be found by using other coordinates like that
		int h = d+f-b;
		
		System.out.println("          y");//Printing y at the beginning of axis. 
		
		for (int row = 11; row >= -10; row--) {
			for (int col = -10; col <= 11; col++) {
				
				//Each boolean variable includes 1 line control. We can make it more readable like that. After checking the equation, we must check max and min points also
				boolean checkEdge1 = ((d-b)*(col-c)==(row-d)*(c-a)) && (col<=Max(a, c) && col >= Min(a, c)) && (row<=Max(b, d) && row >= Min(b, d)); //(a,b) (c,d)
				boolean checkEdge2 = ((f-b)*(col-e)==(row-f)*(e-a)) && (col<=Max(a, e) && col >= Min(a, e)) && (row<=Max(b, f) && row >= Min(b, f)); //(a,b) (e,f)
				boolean checkEdge3 = ((h-d)*(col-g)==(row-h)*(g-c)) && (col<=Max(c, g) && col >= Min(c, g)) && (row<=Max(d, h) && row >= Min(d, h)); //(c,d) (g,h)
				boolean checkEdge4 = ((h-f)*(col-g)==(row-h)*(g-e)) && (col<=Max(e, g) && col >= Min(e, g)) && (row<=Max(f, h) && row >= Min(f, h)); //(e,f) (g,h)
				if(checkEdge1 || checkEdge2 || checkEdge3 || checkEdge4) { //If one of our booleans is true, print *
					System.out.print("*");
				}else if(col == 0) {
					System.out.print("|"); //All same in LineShape
				} else if(row == 0) {
					System.out.print("-");
				} else {
					System.out.print(" ");
				}
			}
			if (row == 0) { //Printing x at the ending of axis. 
				System.out.print("x");
			}
			System.out.println();
		}
	}
	
	public static void ParabolaShape(Scanner input) {
		//Formula of parabola => y = ax^2 + bx + c
		
		//Our logic is just check whether our current point makes equation true or not
		System.out.print("Parabola formula is y = ax^2 + bx + c\nPlease enter the coefficients a, b and c: ");
		
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		
		System.out.println("          y");//Printing y at the beginning of axis. 
		
		for (int row = 11; row >= -10; row--) {
			for (int col = -10; col <= 11; col++) {
				
				
				if((a*col*col)+(b*col)+c == row) { // If current point make the equation true, print *
					System.out.print("*");
				}else if(col == 0) {
					System.out.print("|"); //All same in LineShape
				} else if(row == 0) {
					System.out.print("-");
				} else {
					System.out.print(" ");
				}
			}
			if (row == 0) { //Printing x at the ending of axis. 
				System.out.print("x");
			}
			System.out.println();
		}
	}
	
	public static void CircleShape(Scanner input) {
		//Formula of circle => (x - a)^2 + (y - b)^2 = r^2
		
		//Our logic is just check whether our current point makes equation true or not
		
		System.out.print("Circle formula is (x-a)^2 + (y-b)^2 = r^2\nPlease enter the coordinates of the center (a,b) and the radius:");
		
		int a = input.nextInt();
		int b = input.nextInt();
		int r = input.nextInt();
		
		System.out.println("          y");//Printing y at the beginning of axis. 
		
		for (int row = 11; row >= -10; row--) {
			for (int col = -10; col <= 11; col++) {
				
				
				if(Math.pow((col-a),2)+Math.pow((row-b),2) == r*r) { // If current point make the equation true, print *
					System.out.print("*");
				}else if(col == 0) {
					System.out.print("|"); //All same in LineShape
				} else if(row == 0) {
					System.out.print("-");
				} else {
					System.out.print(" ");
				}
			}
			if (row == 0) { //Printing x at the ending of axis. 
				System.out.print("x");
			}
			System.out.println();
		}
	}
	
	public static int Min(int a, int b) { return ((a <= b) ? a : b); } //Two small functions which returns max or min of 2 parameters.
	public static int Max(int a, int b) { return ((a >= b) ? a : b); } 
}
