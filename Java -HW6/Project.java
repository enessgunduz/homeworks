//Muhammed Enes Gündüz - 150120038
public class Project {
	private String projectName;
	private java.util.Calendar startDate;
	private boolean state;
	
	public Project(String pName, java.util.Calendar startDate, String state) {
		projectName = pName;
		this.startDate = startDate;
		if(state.equals("Open")) {
			this.state = true;
		}else if(state.equals("Close")) {
			this.state=false;
		}
	}
	
	public void setState(String state) throws Exception {
		if(state.length()<3) { //Handling errors
			throw new Exception("Invalid string parameter entered, please check your parameter");
		}
		if(state.equals("Open")) {
			this.state = true;
		}else if(state.equals("Close")) {
			this.state=false;
		}
	}
	
	public String getState() {
		return state ? "Open" : "Close";
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public void close() {
		state = false;
	}
	
	public String toString() {
		return "[Project [projectName="+projectName+", startDate="+startDate.get(5)+"/"+startDate.get(2)+"/"+startDate.get(1)+", state="+state+"]";
	}
}
