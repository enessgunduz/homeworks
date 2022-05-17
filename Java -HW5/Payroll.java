//Muhammed Enes Gündüz | 150120038
//Purpose : Our purpose is implement a factory simulator program with object-oriented approach.
//How to : Defining various classes that makes our job easier : Item, Payroll, Employee, Storage and Factory.
public class Payroll { //creating Payroll class
	private int workHour; //defining private variables
	private int itemCount;
	
	public Payroll(int workHour, int itemCount) { //creating constructor that sets our private variables.
		this.workHour = workHour;
		this.itemCount = itemCount;
	}
	
	public int calculateSalary() { //defining a function that returns total salary
		return workHour*3 + itemCount*2;
	}
	
	public String toString() { //defining a function that returns the information in string
		return "The work hour is "+ workHour + " and the produced item count is "+ itemCount;
	}
}
