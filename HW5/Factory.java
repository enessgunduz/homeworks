//Muhammed Enes Gündüz | 150120038
//Purpose : Our purpose is implement a factory simulator program with object-oriented approach.
//How to : Defining various classes that makes our job easier : Item, Payroll, Employee, Storage and Factory.
public class Factory { //creating Factory class
	private String name;
	private Employee[] employees;
	private Storage storage; //defining various variables in different types.
	private Payroll[] payrolls;
	private double itemPrice;
	
	public Factory(String name, int capacity, double itemPrice) { //Creating constructor and setting the variables' values. And also creating our arrays.
		this.name=name;
		storage = new Storage(capacity);
		this.itemPrice=itemPrice;
		payrolls = new Payroll[0];
		employees = new Employee[0];
	}
	
	public double getRevenue() { //creating a function that returns storage's item count times item price.
		return storage.getItemCount()*itemPrice;
	}
	
	public double getPaidSalaries() { // creating a function that takes all the payrolls and add their salary and return total amount of them.
		double paidSalaries = 0;
		for (int i = 0; i < payrolls.length; i++) {
			paidSalaries+=payrolls[i].calculateSalary(); //taking each salary
		}
		return paidSalaries;
	}
	
	public void addEmployee(Employee employee) { //creating a function that adds new employee
		Employee[] temp = employees;
		employees = new Employee[temp.length+1];
		for (int i = 0; i < temp.length; i++) { //Create a new array that holds our initial array. Then add 1 to our initial array's lenght.
			employees[i] = temp[i];             //By doing that, we will create a new array. Then fill the first items of this array with the array that we created
		}                                       //at the beggining. And add the item as our array's last element
		employees[employees.length-1] = employee;
		
		Item[] employeesItems = employee.startShift(); //staring new employee's shift by it's method.
		for (int i = 0; i < employeesItems.length; i++) {
			storage.addItem(employeesItems[i]); //adds the items that the employee just created
		}
	}
	
	public Employee removeEmployee(int id) { //creating a function that removes an employee
		Employee removedEmployee = null;
		if(employees.length==0) { //if there is no employee, printing a message and returning
			System.out.println("There are no employees!"); 
			return null;
		}
		for (int i = 0; i < employees.length; i++) { 
			if(employees[i].getId() == id) { //checking whether the id is equal an employee's id or not
				removedEmployee = employees[i]; //creating removedEmployee as the employee that will be removed
				addPayroll(employees[i].endShift()); //adding payroll with employee's endShift method
				
				Employee[] temp = employees;              //Create a new array that holds our initial array. Then subtract 1 from our initial array's lenght.
				employees = new Employee[temp.length-1];  //By doing that, we will create a new array. Then fill the first items of this array with the array that we created
				for (int j = 0; j < temp.length; j++) {   //at the beggining. We must skip the employee that we will remove.
					if(i>j) { //checking whether we come our employee's index or not                    
						employees[j] = temp[j]; 
					} else if(i<j) {
						employees[j-1] = temp[j];
					}
					
				}
				break;
				
			} else if (employees[i].getId() != id && i == employees.length-1) { //if there is no employee with that id, printing message and returning
				System.out.println("Employee does not exist!");
				return null;
			}
		}
		
		return removedEmployee;
	}
	
	private void addPayroll(Payroll payroll) { //creating a function that adds a new payroll
		Payroll[] temp = payrolls; 
		payrolls = new Payroll[temp.length+1]; //Create a new array that holds our initial array. Then add 1 to our initial array's lenght.
		for (int i = 0; i < temp.length; i++) {//By doing that, we will create a new array. Then fill the first items of this array with the array that we created
			payrolls[i] = temp[i];             //at the beggining. And add the item as our array's last element
		}
		payrolls[payrolls.length-1] = payroll;
	}
}
