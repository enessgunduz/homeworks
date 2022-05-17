//Muhammed Enes Gündüz - 150120038
public class Department {
	private int departmentId;
	private String departmentName;
	
	public Department(int departmentId, String departmentName) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	
	public String toString() {
		return "Department [departmentId="+departmentId+", departmentName="+departmentName+"]";
	}
}
