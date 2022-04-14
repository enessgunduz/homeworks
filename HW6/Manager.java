
import java.util.ArrayList;
//Muhammed Enes Gündüz - 150120038
public class Manager extends Employee{
	private ArrayList<RegularEmployee> regularEmployees = new ArrayList<>();
	private double bonusBudget;
	
	public Manager(int id, String firstName, String lastName, String gender,
			java.util.Calendar birthDate, String maritalStatus, String hasDriverLicence,
			double salary, java.util.Calendar hireDate, Department department,double
			bonusBudget) {
		super(id,firstName,lastName,gender,birthDate,maritalStatus,hasDriverLicence,salary,hireDate,department);
		this.bonusBudget = bonusBudget;
	}
	
	public Manager(Employee employee, double bonusBudget) {
		super(employee.getId(),employee.getFirstName(),employee.getLastName(),employee.getGender()
				,employee.getBirthDate(),employee.getMaritalStatus(),employee.getHasDriverLicence(),employee.getSalary(), employee.getHireDate(),employee.getDepartment());
		this.bonusBudget = bonusBudget;
	}
	
	public void addEmployee(RegularEmployee e) {
		regularEmployees.add(e);
	}
	
	public void removeEmployee(RegularEmployee e) {
		regularEmployees.remove(e);
	}
	
	public void distributeBonusBudget() throws Exception {
		double unit = 0; //Distributing bonus budget by the formula given
		for (RegularEmployee regularEmployee : regularEmployees) {
			unit += regularEmployee.getSalary()*regularEmployee.getPerformanceScore();
		}
		unit = bonusBudget/unit;
		for (RegularEmployee regularEmployee : regularEmployees) {
			regularEmployee.setBonus(unit*regularEmployee.getSalary()*regularEmployee.getPerformanceScore());
		}
	}
	
	public String toString() {
		
		
		return "	Manager [id:"+ getId()+", "+getFirstName()+" "+getLastName()+"\n" + 
				"		# of Employees: "+regularEmployees.size()+"]";
				
	}
}
