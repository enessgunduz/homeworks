
//Muhammed Enes Gündüz - 150120038
public class Employee extends Person{
	private double salary;
	private java.util.Calendar hireDate;
	private Department department;
	public static int numberofEmployees;
	
	public Employee(int id, String firstName, String lastName, String gender,
			java.util.Calendar birthDate, String maritalStatus, String hasDriverLicence,
			double salary, java.util.Calendar hireDate, Department department) {
		super(id,firstName,lastName,gender,birthDate,maritalStatus,hasDriverLicence);
		this.salary=salary;
		this.hireDate = hireDate;
		this.department = department;
		numberofEmployees++;
	}
	
	public Employee(Person person, double salary, java.util.Calendar hireDate, Department
			department) {
		super(person.getId(),person.getFirstName(),person.getLastName(),person.getGender()
				,person.getBirthDate(),person.getMaritalStatus(),person.getHasDriverLicence());
		this.salary=salary;
		this.hireDate = hireDate;
		this.department = department;
		numberofEmployees++;
	}
	
	public double raiseSalary(double percent) throws Exception {
		if(percent<0) { //Handling errors
			throw new Exception("Raise salary method cannot take a negative parameter");
		}
		salary += salary*percent;
		return salary;
	}
	
	public double raiseSalary(int amount) throws Exception {
		if(amount<0) {
			throw new Exception("Raise salary method cannot take a negative parameter");
		}
		salary += amount;
		return salary;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public java.util.Calendar getHireDate(){
		return hireDate;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	public String getEmployeeInfo() {
		return "Employee Info [salary="+salary+", hireDate="+hireDate.get(5)+"/"+hireDate.get(2)+"/"+hireDate.get(1)+"]";
	}
	
	public String toString() {
		return "Employee Info [salary="+salary+", hireDate="+hireDate.get(5)+"/"+hireDate.get(2)+"/"+hireDate.get(1)+"]";
	}

}
