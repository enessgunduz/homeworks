//Muhammed Enes Gündüz | 150120038
//Purpose : Our purpose is implement a factory simulator program with object-oriented approach.
//How to : Defining various classes that makes our job easier : Item, Payroll, Employee, Storage and Factory.
public class Item { //creating Item class
	private int id;
	public static int numberOfItems; //defining static and normal variables
	
	public Item(int id){ //building constructor and setting id as the parameter id and add 1 to numberOfItems
		this.id = id;
		numberOfItems++;
	}
}
