
import java.util.ArrayList;
//Muhammed Enes Gündüz - 150120038
public class Customer extends Person{
	private ArrayList<Product> products;
	
	public Customer(int id, String firstName, String lastName, String gender,
			java.util.Calendar birthDate, String maritalStatus,String hasDriverLicence,
			ArrayList<Product> products) {
		super(id,firstName,lastName,gender,birthDate,maritalStatus,hasDriverLicence);
		this.products = products;
		
	}
	
	public Customer(Person person, ArrayList<Product> products) {
		super(person.getId(),person.getFirstName(),person.getLastName(),person.getGender()
				,person.getBirthDate(),person.getMaritalStatus(),person.getHasDriverLicence());
		this.products = products;
	}
	
	public String toString() {
		String str = "";
		for (Product product : products) {
			str+=product.toString();
			if(products.indexOf(product)!= products.size()-1) {
				str+= ", ";
			}
		}
		return "Customer [id: "+getId()+" products="+ str;
	}		

}
