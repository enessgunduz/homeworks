import java.util.ArrayList;
//Muhammed Enes Gündüz - 150120038
public class SalesEmployee extends RegularEmployee{
	private ArrayList<Product> sales;
	public static int numberOfSalesEmployees;
	
	public SalesEmployee(int id, String firstName, String lastName, String gender,
			java.util.Calendar birthDate, String maritalStatus, String hasDriverLicence,
			double salary, java.util.Calendar hireDate, Department department, double
			pScore, ArrayList<Product> s) {
		super(id,firstName,lastName,gender,birthDate,maritalStatus,hasDriverLicence,salary
				,hireDate,department,pScore);
		this.sales = s;
		numberOfSalesEmployees++;
	}
	
	public SalesEmployee(RegularEmployee re, ArrayList<Product> s) {
		super(re.getId(),re.getFirstName(),re.getLastName(),re.getGender()
				,re.getBirthDate(),re.getMaritalStatus(),re.getHasDriverLicence(),re.getSalary(), re.getHireDate(),re.getDepartment(), re.getPerformanceScore());
		this.sales = s;
		numberOfSalesEmployees++;
	}
	
	public boolean addSale(Product s) {
		return sales.add(s);
	}
	
	public boolean removeSale(Product s) {
		return sales.remove(s);
	}
	
	public double countOfSale() {
		double a = 0;
		for (Product product : sales) {
			a+= product.getPrice();
		}
		return a;
	}
	
	public String toString() {
		String productsStr = "";
		for (Product product : sales) {
			productsStr+= product.toString();
			if(sales.indexOf(product)!=sales.size()-1) {
				productsStr+= ", ";
			}
		}
		return "SalesEmployee \n" + 
				"				"+getPersonInfo()+"\n" + 
				"				"+getEmployeeInfo()+"\n" + 
				"				"+getRegularEmployeeInfo()+"\n" + 
				"				"+productsStr;
	}
}
