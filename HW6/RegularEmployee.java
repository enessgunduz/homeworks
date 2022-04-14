
//Muhammed Enes Gündüz - 150120038
public class RegularEmployee extends Employee{
	private double performanceScore;
	private double bonus;
	
	public RegularEmployee(int id, String firstName, String lastName, String
			gender, java.util.Calendar birthDate, String maritalStatus, String
			hasDriverLicence, double salary, java.util.Calendar hireDate, Department
			department, double performanceScore) {
		super(id,firstName,lastName,gender,birthDate,maritalStatus,hasDriverLicence,salary,hireDate,department);
		this.performanceScore = performanceScore;
	}
	
	public RegularEmployee(Employee employee, double perfScore) {
		super(employee.getId(),employee.getFirstName(),employee.getLastName(),employee.getGender()
				,employee.getBirthDate(),employee.getMaritalStatus(),employee.getHasDriverLicence(),employee.getSalary(), employee.getHireDate(),employee.getDepartment());
		this.performanceScore = perfScore;
	}
	
	public double getPerformanceScore() {
		return performanceScore;
	}
	
	public void setBonus(double bonus) throws Exception {
		if(bonus<0) {
			throw new Exception("Bonus cannot be negative");
		}
		this.bonus = bonus;
	}
	
	public double getBonus() {
		return bonus;
	}
	
	public String getRegularEmployeeInfo() {
		return "RegularEmployee Info [performanceScore="+performanceScore+", bonus="+(int)(bonus*100)/100.0+"]";
	}
	
	public String toString() {
		return "RegularEmployee \n" + 
				"				"+getPersonInfo()+"\n" + 
				"				"+getEmployeeInfo()+"\n" + 
				"				"+getRegularEmployeeInfo()+"\n";
	}
}
