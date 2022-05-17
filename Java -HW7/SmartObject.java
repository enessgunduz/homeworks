//Muhammed Enes Gündüz - 150120038

public abstract class SmartObject {
	private String alias;
	private String macId;
	private String IP;
	private boolean connectionStatus;
	
	public SmartObject() {
		
	}
	
	//Setting variables
	public boolean connect(String IP) {
		this.IP = IP;
		connectionStatus = true;
		System.out.println(alias + " connection established");
		return true;
	}
	
	public boolean disconnect() {
		IP = "";
		connectionStatus = false;
		return true;
	}
	
	public void SmartObjectToString() {
		System.out.println("This is "+ getClass().getName() + " "+ alias +"\n\tMacId: "+macId+"\n\tIP: "+IP);
	}
	
	public boolean controlConnection() {
		if(!connectionStatus) {
			System.out.println("This device is not connected."+ getClass().getName() +" -> "+alias);
			return false;
		} else {
			return true;
		}
	}
	
	//Defining abstact methods
	public abstract boolean testObject();
	
	public abstract boolean shutDownObject();
		
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public String getAlias() {
		return alias;
	}
	
	public void setMacId(String macId) {
		this.macId = macId;
	}
	
	public String getIp() {
		return IP;
	}
	}
	

