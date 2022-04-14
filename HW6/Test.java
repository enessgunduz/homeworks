import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;
public class Test {

	//Muhammed Enes Gündüz - 150120038
	//Purpose : The purpose is, create a company system which reads informations from a text file and turn them into a meaningful output.  
	
	static ArrayList<Department> departments = new ArrayList<>();
	static ArrayList<Project> projects = new ArrayList<>();
	static ArrayList<Product> products = new ArrayList<>();	 //Creating new arraylists for inputs
	static ArrayList<Person> people = new ArrayList<>();
	
	static PrintWriter writer = null;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		
		File inputFile = new File("input.txt"); //Opening input file and handling errors
		if(!inputFile.exists()) {
			System.out.println("Input file not found");
			System.exit(0);
		}
		
		try {
			writer = new PrintWriter("output.txt", "UTF-8"); //Opening or if not exists, creating a output file and handling errors
		} catch (UnsupportedEncodingException e1) {
			System.out.println("Output file has unsupported encoding. Please check your file.");
			System.exit(0);
		}
		
		
		
		Scanner input = new Scanner(inputFile);
		
		try {
			while(input.hasNextLine()) {
				String[] inputElements = input.nextLine().split(" "); //Taking inputs as a line and split them 
				Calendar date = Calendar.getInstance();
				String first = inputElements[0];
				if(first.equals("Department")) { //Checking first word of inputs and understanding which object it will be
					checkValidate(1, inputElements); //Checking if inputs come correctly or not
					departments.add(new Department(toInt(inputElements[1]), inputElements[2])); //Adding the new object to arraylist
				} else if(first.equals("Project")) {
					checkValidate(2, inputElements);
					String[] values = inputElements[2].split("/"); //All here is same as department
					date.set(toInt(values[2]), toInt(values[1]), toInt(values[0]));
					projects.add(new Project(inputElements[1], date, inputElements[3]));
				} else if(first.equals("Product")) {
					checkValidate(3, inputElements);
					String[] values = inputElements[2].split("/"); //All here is same as department
					date.set(toInt(values[2]), toInt(values[1]), toInt(values[0]));
					products.add(new Product(inputElements[1], date, Integer.parseInt(inputElements[3])));
				} else if(first.equals("Person")) {
					checkValidate(4, inputElements);
					String[] values = inputElements[5].split("/");
					date.set(toInt(values[2]), toInt(values[1]), toInt(values[0])); //All here is same as department
					people.add(new Person(toInt(inputElements[3]), inputElements[1], inputElements[2], inputElements[4], date, inputElements[6], inputElements[7]));
					
					
				} else if(first.equals("Employee")) {
					
					checkValidate(5, inputElements);
					Department department = null;
					
					for (Department d : departments) {
						if(d.getDepartmentName().equals(inputElements[4])) {
							department = d; //Finding the department of Employee
							break;
						}
					}
					String[] values = inputElements[3].split("/");
					date.set(toInt(values[2]), toInt(values[1]), toInt(values[0]));
					
					for (Person p : people) {
						if(p.getId() == toInt(inputElements[1])) {
							people.add(new Employee(p, toInt(inputElements[2]), date, department)); //Keeping all persons in a arraylist polimorphically
							people.remove(p);
							break;
						}
					}

					
					
				} else if(first.equals("Manager")) {
					
					checkValidate(6, inputElements);
					for (Person e : people) {
						if(e instanceof Employee) {
							if(e.getId() == toInt(inputElements[1])) {
								people.add(new Manager((Employee) e, toInt(inputElements[2]))); //Same as employee
								people.remove(e);	
								break;
							}
						}
					}

					
				} else if(first.equals("RegularEmployee")) {
					checkValidate(7, inputElements);
					for (Person e : people) {
						if(e instanceof Employee) {
							if(e.getId() == toInt(inputElements[1])) {
								people.add(new RegularEmployee((Employee) e, toInt(inputElements[2]))); //Same as employee
								people.remove(e);		
								break;
							}
						}
					}
					
					
				} else if(first.equals("Developer")) {
					checkValidate(8, inputElements);
					ArrayList<Project> devProjects = new ArrayList<>();
					
					for (int i = 2; i < inputElements.length; i++) {
						for (Project project : projects) {
							if(project.getProjectName().equals(inputElements[i])) {
								devProjects.add(project);
								break;
							}
						}
					}
					
					for (Person re : people) {
						if(re instanceof RegularEmployee) {
							if(re.getId() == toInt(inputElements[1])) {
								people.add(new Developer((RegularEmployee) re, devProjects));
								people.remove(re); //Same as employee
								
								break;
							}
						}
					}

					
					
				} else if(first.equals("SalesEmployee")) {
					checkValidate(9, inputElements);
					ArrayList<Product> salesProducts = new ArrayList<>();
					for (int i = 2; i < inputElements.length; i++) {
						for (Product product : products) {
							if(product.getProductName().equals(inputElements[i])) {
								salesProducts.add(product); 
								break;
							}
						}
					}
					
					for (Person re : people) {
						if(re instanceof RegularEmployee) {
							if(re.getId() == toInt(inputElements[1])) {
								people.add(new SalesEmployee((RegularEmployee) re, salesProducts));
								people.remove(re); //Same as employee
								
								break;
							}
						}
					}

					
					
				} else if(first.equals("Customer")) {
					checkValidate(10, inputElements);
					ArrayList<Product> customerProducts = new ArrayList<>();
					for (int i = 2; i < inputElements.length; i++) {
						for (Product product : products) {
							if(product.getProductName().equals(inputElements[i])) {
								customerProducts.add(product); 
								break;
							}
						}
					}
					
					for (Person p : people) {
						if(p.getId() == toInt(inputElements[1])) {
							people.add(new Customer(p,customerProducts));
							people.remove(p); //Same as employee
							
							break;
						}
					}

					
				} else {
					throw new Exception("Invalid input, one of your input line doesn't start with keyword that spesify what it is. Please check your inputs' first parameter");
				}
			}
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			System.exit(0);
		}
		
		
		/**Matching managers and their employees*/
		for (Department d : departments) {
			for (Person manager : people) {
				if(manager instanceof Manager) {
					if(((Manager) manager).getDepartment().getDepartmentName().equals(d.getDepartmentName())) {
						for (Person rEmployee : people) {
							if((rEmployee instanceof RegularEmployee) && !(rEmployee instanceof Developer) && !(rEmployee instanceof SalesEmployee)) {
								//Handling only regular employees, not developers or sales employees
								if(((RegularEmployee)rEmployee).getDepartment().getDepartmentName().equals(d.getDepartmentName())) {
									((Manager) manager).addEmployee((RegularEmployee) rEmployee);
								}
							}
						}
						for (Person a : people) {
							if(a instanceof Developer) {
								if(((Developer) a).getDepartment().getDepartmentName().equals(d.getDepartmentName())) {	
									((Manager) manager).addEmployee((RegularEmployee)a);
								}
							}
							
						}
						for (Person c : people) {
							if(c instanceof SalesEmployee) {
								if(((SalesEmployee) c).getDepartment().getDepartmentName().equals(d.getDepartmentName())) {	
									((Manager) manager).addEmployee((RegularEmployee) c);
								}
							}
							
						}

					}
				}
				
			}
		}
		
		
		operations(); //The function for operations
		
		
		
		printAll(); //The function for printing and writing everything in details
		
		
	}
	
	public static void operations() {
		try {
			/**All operations must be written in try block and if you want to call a person, you must call it polymorphically in people arraylist*/
			
			for (Person manager : people) {
				if(manager instanceof Manager) {
					((Manager) manager).distributeBonusBudget();
				}
			}
			for (Person manager : people) {
				if(manager instanceof Manager) {
					((Manager) manager).raiseSalary(0.2);
				}
			}
			for (Person rEmployee : people) {
				if(rEmployee instanceof RegularEmployee && !(rEmployee instanceof Developer) && !(rEmployee instanceof SalesEmployee)) {
					((RegularEmployee) rEmployee).raiseSalary(0.3);
				}
			}
			for (Person d : people) {
				if(d instanceof Developer) {
					((Developer) d).raiseSalary(0.23);
				}
			}
			for (Person s : people) {
				if(s instanceof SalesEmployee) {
					((SalesEmployee) s).raiseSalary(0.18);
				}
			}
			SalesEmployee best = null;
			for (Person s : people) {	
				
				if(s instanceof SalesEmployee) {
					if(best != null) {
						if(((SalesEmployee) s).countOfSale()>best.countOfSale()) {
							best = (SalesEmployee) s; //Finding the best sales employee 
						}
					} else {
						best = (SalesEmployee) s;
					}
				}
			}
			
			best.raiseSalary(1000);
			
			
			
		} catch (Exception ex) {
			
			System.out.println(ex.getMessage());
			System.exit(0);
		}
		
		
		
	}
	
	/**This function checks all inputs and throws exception if there is an error*/
	public static void checkValidate(int i, String[] inputs) throws Exception{
		String wrongNumberOfParameters = "Invalid input, one of your input line has less or more parameter then minimum size. Please check your inputs' parameter count";
		String lenghtOfString = "Invalid input, one of your input line has a string parameter that has characters less than 3. Please check your inputs' parameters";
		String negativeNumber = "Invalid input, one of your input line has a negative numerical value. Please check your inputs' parameters";
		switch (i) {
		case 1:
			if(inputs.length!=3) {
				throw new Exception(wrongNumberOfParameters);
			}
			if(inputs[0].length() < 3 || inputs[2].length()<3) { //Checking inputs' element counts, string lenghts and if numbers are negative or not
				throw new Exception(lenghtOfString);
			}
			if(toInt(inputs[1]) <0) {
				throw new Exception(negativeNumber);
			}
			break;
		case 2:
			if(inputs.length!=4) {
				throw new Exception(wrongNumberOfParameters);
			}
			if(inputs[0].length() < 3 || inputs[1].length()<3 || inputs[3].length()<3) {
				throw new Exception(lenghtOfString);
			}
			break;
		case 3:
			if(inputs.length!=4) {
				throw new Exception(wrongNumberOfParameters);
			}
			if(inputs[0].length() < 3 || inputs[1].length()<3) {
				throw new Exception(lenghtOfString);
			}
			if(toInt(inputs[3]) <0) {
				throw new Exception(negativeNumber);
			}
			break;
		case 4:
			if(inputs.length!=8) {
				throw new Exception(wrongNumberOfParameters);
			}
			if(inputs[0].length() < 3 || inputs[1].length()<3 || inputs[2].length()<3 || inputs[4].length()<3 || inputs[6].length()<3) {
				throw new Exception(lenghtOfString);
			}
			if(toInt(inputs[3]) <0) {
				throw new Exception(negativeNumber);
			}
			break;
		case 5:
			if(inputs.length!=5) {
				throw new Exception(wrongNumberOfParameters);
			}
			if(inputs[0].length() < 3 || inputs[4].length()<3) {
				throw new Exception(lenghtOfString);
			}
			if(toInt(inputs[1]) <0 || toInt(inputs[2]) <0) {
				throw new Exception(negativeNumber);
			}
			break;
		case 6:
			if(inputs.length!=3) {
				throw new Exception(wrongNumberOfParameters);
			}
			if(inputs[0].length() < 3) {
				throw new Exception(lenghtOfString);
			}
			if(toInt(inputs[1]) <0 || toInt(inputs[2]) <0) {
				throw new Exception(negativeNumber);
			}
			break;
		case 7:
			if(inputs.length!=3) {
				throw new Exception(wrongNumberOfParameters);
			}
			if(inputs[0].length() < 3) {
				throw new Exception(lenghtOfString);
			}
			if(toInt(inputs[1]) <0 || toInt(inputs[2]) <0) {
				throw new Exception(negativeNumber);
			}
			break;
		case 8:
			if(inputs.length<3) {
				throw new Exception(wrongNumberOfParameters);
			}
			for (int j = 2; j < inputs.length; j++) {
				if(inputs[j].length() < 3) {
					throw new Exception(lenghtOfString);
				}
			}
			
			if(toInt(inputs[1]) <0) {
				throw new Exception(negativeNumber);
			}
			break;
		case 9:
			if(inputs.length<3) {
				throw new Exception(wrongNumberOfParameters);
			}
			for (int j = 2; j < inputs.length; j++) {
				if(inputs[j].length() < 3) {
					throw new Exception(lenghtOfString);
				}
			}
			
			if(toInt(inputs[1]) <0) {
				throw new Exception(negativeNumber);
			}
			break;
		case 10:
			if(inputs.length<3) {
				throw new Exception(wrongNumberOfParameters);
			}
			for (int j = 2; j < inputs.length; j++) {
				if(inputs[j].length() < 3) {
					throw new Exception(lenghtOfString);
				}
			}
			
			if(toInt(inputs[1]) <0) {
				throw new Exception(negativeNumber);
			}
			break;
		
		}
	}
	
	//Just a function to parsing int easly
	public static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	/**Function that prints all the things in details and writes everything in a file. It calls all people's toString methods in order.*/
	public static void printAll() {
		
		
		
		writer.println("************************************************"); //These are for writing in output file
		System.out.println("************************************************"); //These are for writing in console
		for (Department d : departments) {
			writer.println(d.toString());
			System.out.println(d.toString());
			for (Person manager : people) {
				if(manager instanceof Manager) {
					if(((Manager) manager).getDepartment().getDepartmentName().equals(d.getDepartmentName())) {
						writer.println(manager.toString());
						System.out.println(manager.toString());
					}
				}
				
			}
			int i = 1;
			for (Person developer : people) {
				if(developer instanceof Developer) {
					if(((Developer) developer).getDepartment().getDepartmentName().equals(d.getDepartmentName())) {
						writer.println("\t\t\t"+i+". "+developer.toString());
						System.out.println("\t\t\t"+i+". "+developer.toString());
						i++;
						
					}
				}
				
			}
			for (Person sEmployee : people) {
				if(sEmployee instanceof SalesEmployee) {
					if(((SalesEmployee) sEmployee).getDepartment().getDepartmentName().equals(d.getDepartmentName())) {
						writer.println("\t\t\t"+i+". "+sEmployee.toString());
						System.out.println("\t\t\t"+i+". "+sEmployee.toString());
						i++;
						
					}
				}
				
			}
			for (Person rEmployee : people) {
				if((rEmployee instanceof RegularEmployee) && !(rEmployee instanceof Developer) && !(rEmployee instanceof SalesEmployee)) {
					if(((RegularEmployee) rEmployee).getDepartment().getDepartmentName().equals(d.getDepartmentName())){
						writer.println("\t\t\t"+i+". "+rEmployee.toString());
						System.out.println("\t\t\t"+i+". "+rEmployee.toString());
						i++;
											
					}
				}
			}

			
			if(departments.indexOf(d)!=departments.size()-1) {
				writer.println("************************************************");
				System.out.println("************************************************");
			} else {
				writer.println("**********************CUSTOMERS************************");
				System.out.println("**********************CUSTOMERS************************");
				for (Person customer : people) {
					if(customer instanceof Customer) {
						writer.println(customer.toString());
						System.out.println(customer.toString());
					}
					
				}
				writer.println("\n\n**********************PEOPLE************************");
				System.out.println("\n\n**********************PEOPLE************************");
				
				for (Person person : people) {
					if(!(person instanceof Employee) && !(person instanceof Customer)) {
						writer.println(person.getLongPersonInfo());
						System.out.println(person.getLongPersonInfo());
					}
				}
				
			}
		}
		
		writer.close();
		
	}
	
	
	

}
