//Muhammed Enes Gündüz | 150120038
//Purpose : Our purpose is implement a factory simulator program with object-oriented approach.
//How to : Defining various classes that makes our job easier : Item, Payroll, Employee, Storage and Factory.
public class Storage { //creating Storage class
	private int capacity; //defining variables
	private Item[] items;
	
	public Storage(int capacity) { //creating constructor that sets our variables
		this.capacity=capacity;
		this.items = new Item[0];
	}
	
	public void addItem(Item item) { //defining a function that adds an item to our items array
		Item[] temp = items;
		items = new Item[temp.length+1];
		for (int i = 0; i < temp.length; i++) { //Create a new array that holds our initial array. Then add 1 to our initial array's lenght.
			items[i] = temp[i];                 //By doing that, we will create a new array. Then fill the first items of this array with the array that we created
		}                                       //at the beggining. And add the item as our array's last element
		items[items.length-1] = item;
	}
	
	public int getItemCount() { //creating a function that returns items' lenght.
		return items.length;
	}

}
