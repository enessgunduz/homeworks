//Muhammed Enes Gündüz | 150120038
//Purpose : Our purpose is implement a factory simulator program with object-oriented approach.
//How to : Defining various classes that makes our job easier : Item, Payroll, Employee, Storage and Factory.
public class Employee { //creating Employee class
	private int id;
	private String name;
	private String surname; //defining various variables in different types.
	private int workHour;
	private int speed;
	private Item[] items;
	private Payroll payroll;
	
	public Employee(int id, String name, String surname, int workHour, int speed) { //Creating a constructor that sets our variables' values.
		this.id=id;
		this.name=name;
		this.surname=surname;
		this.workHour=workHour;
		this.speed=speed;
	}
	
	public Item[] startShift() { //defining a function that creates new Items and return an array of items.
		int numberOfItem = speed*workHour; 
		items = new Item[numberOfItem]; //initializating the items array 
		
		java.util.Random myRandom = new java.util.Random(); //creating a object from Random class.
		
		for (int i = 0; i < numberOfItem; i++) {
			items[i] = new Item(myRandom.nextInt(100)); //filling the array with Items that has random ids
		}
		
		return items; 
	}
	
	public Payroll endShift() { //defining a function that returns the employee's payroll
		return payroll = new Payroll(workHour, speed*workHour);
	}
	
	public String toString() {//defining a function that returns the information in string
		return "This is the employee with id "+id +" speed "+speed +". The work hour is "+workHour +" and the produced item count is "+ speed*workHour;
	}
	
	public int getItemCount() {//creating a getter for amount of item
		return workHour*speed;
	}
	
	public int getId() { //creating a getter for id
		return id;
	}
}
