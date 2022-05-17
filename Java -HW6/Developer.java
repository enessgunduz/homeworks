import java.util.ArrayList;
//Muhammed Enes Gündüz - 150120038
public class Developer extends RegularEmployee{
	private ArrayList<Project> projects;
	public static int numberOfDevelopers;
	
	public Developer(int id, String firstName, String lastName, String gender,
			java.util.Calendar birthDate, String maritalStatus, String hasDriverLicence,
			double salary, java.util.Calendar hireDate, Department department, double
			pScore, ArrayList<Project> p) {
		super(id,firstName,lastName,gender,birthDate,maritalStatus,hasDriverLicence,salary
				,hireDate,department,pScore);
		this.projects = p;
		numberOfDevelopers++;
	}

	public Developer(RegularEmployee re, ArrayList<Project> p) {
		super(re.getId(),re.getFirstName(),re.getLastName(),re.getGender()
				,re.getBirthDate(),re.getMaritalStatus(),re.getHasDriverLicence(),re.getSalary(), re.getHireDate(),re.getDepartment(), re.getPerformanceScore());
		this.projects = p;
		numberOfDevelopers++;
	}
	
	public boolean addProject(Project s) {
		return projects.add(s); 
	}
	
	public boolean removeProject(Project s) {
		return projects.remove(s);
	}
	
	public String toString() {
		String projectsStr = "";
		for (Project project : projects) {
			projectsStr+= project.toString();
			if(projects.indexOf(project)!=projects.size()-1) {
				projectsStr+= ", ";
			}
		}
		return "Developer \n" +
				"				"+ getPersonInfo()+"\n" + 
				"				"+getEmployeeInfo()+"\n" + 
				"				"+getRegularEmployeeInfo()+"\n" + 
				"				"+projectsStr;
	}
	
	
}
