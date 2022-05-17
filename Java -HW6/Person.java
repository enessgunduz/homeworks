
//Muhammed Enes Gündüz - 150120038
public class Person {

	private int id;
	private String firstName;
	private String lastName;
	private byte gender;
	private java.util.Calendar birthDate;
	private byte maritalStatus;
	private boolean hasDriverLicence;

	public Person(int id, String firstName, String lastName, String gender,
			java.util.Calendar birthDate, String maritalStatus, String hasDriverLicence) {
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		setGender(gender);
		this.birthDate = birthDate;
		setMaritalStatus(maritalStatus);
		setHasDriverLicence(hasDriverLicence);
	}
	
	public void setGender(String gender) {
		if(gender.equals("Man")) {
			this.gender = 2;
		} else if(gender.equals("Woman")) {
			this.gender=1;
		}
	}
	
	public String getGender() {
		return gender ==1 ? "Woman":"Man";
	}
	
	public void setMaritalStatus(String status) {
		if(status.equals("Single")) {
			maritalStatus = 1;
		} else if(status.equals("Married")) {
			maritalStatus=2;
		}
	}
	
	public String getMaritalStatus() {
		return maritalStatus ==1 ? "Single":"Married";
	}
	
	public void setHasDriverLicence(String info) {
		if(info.equals("Yes")) {
			hasDriverLicence = true;
		}else if(info.equals("No")) {
			hasDriverLicence=false;
		}
	}
	
	public String getHasDriverLicence() {
		return hasDriverLicence ? "Yes" : "No";
	}
	
	public String getLongPersonInfo() {
		return "Person Info [id="+id+", firstName="+firstName+", lastName="+lastName+", gender="+getGender()+", birthDate="+birthDate.get(5)+"/"+birthDate.get(2)+"/"+birthDate.get(1)+", maritalStatus="+getMaritalStatus()+", hasDriverLicence="+getHasDriverLicence()+"]";
	}
	
	public String getPersonInfo() {
		return "Person Info [id="+id+", firstName="+firstName+", lastName="+lastName+", gender="+getGender()+"]";
	}
	
	public String toString() {
		return "Person Info [id="+id+", firstName="+firstName+", lastName="+lastName+", gender="+getGender()+"]";
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setBirthDate(java.util.Calendar birthDate) {
		this.birthDate = birthDate;
	}
	
	public java.util.Calendar getBirthDate(){
		return birthDate;
	}
}
