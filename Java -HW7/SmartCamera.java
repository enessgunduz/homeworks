//Muhammed Enes Gündüz - 150120038

public class SmartCamera extends SmartObject implements MotionControl, Comparable<SmartCamera>{
	private boolean status;
	private int batteryLife;
	private boolean nightVision;
	
	//Setting variables by constructor's parameters
	public SmartCamera(String alias, String macId, boolean nightVision, int batteryLife) {
		setAlias(alias);
		setMacId(macId);
		this.nightVision = nightVision;
		this.batteryLife = batteryLife;
	}
	
	
	public void recordOn(boolean isDay) {
		if(controlConnection()) { //If connection is ok
			if(!status) { //If camera already not recording
				if(isDay || (!isDay && nightVision)) { //If it is day time or it is not and have night vision
					status = true;
					System.out.println("Smart Camera - "+getAlias()+" is turned on now");
				} else { //If the camera don't have night vision
					System.out.println("Sorry! Smart Camera -" +getAlias()+" does not have night vision feature.");
				}
			} else { //If camera already turned
				System.out.println("Smart Camera - "+getAlias()+" has been already turned");
			}
			
		}
	}
	
	public void recordOff() {
		if(controlConnection()) {
			if(status) { //If camera is on
				status = false;
				System.out.println("Smart Camera - "+ getAlias() + " is turned off now");
			} else { //If camera is already off
				System.out.println("Smart Camera - "+ getAlias()+" has been already turned off");
			}
		} 
	}
	
	/**Checking all functionality of Smart Object*/
	public boolean testObject() {
		if(controlConnection()) {
			SmartObjectToString();
			System.out.println("Test is starting for SmartCamera day time");
			recordOn(true);
			recordOff();
			System.out.println("Test is starting for SmartCamera night time");
			recordOn(false);
			recordOff();
			System.out.println("Test completed for SmartCamera");
			return true;
		} else {
			return false;
		}
	}
	
	
	public boolean shutDownObject() {
		if(controlConnection()) {
			if(status) {
				SmartObjectToString();
				recordOff(); //Record off if status is true
			}
			return true;
		} else {
			return false;
		}
	}
	
	public boolean controlMotion(boolean hasMotion, boolean isDay) {
		if(hasMotion) { //If there is a motion
			System.out.println("Motion detected!");
			if(isDay) { //If it is daytime
				recordOn(isDay);
				return true;
			} else if(!isDay && nightVision){ //If it is not daytime and have night vision
				recordOn(isDay);
				return true;
			}
			return false;
		} else {
			System.out.println("Motion not detected!");
			return false;
		}
	}
	
	
	public String toString() {
		String stat = status ? "recording" : "not recording";
		return "SmartCamera -> " +getAlias()+"'s battery life is "+batteryLife+" status is "+stat;
	}

	/**Default compareTo method*/
	@Override
	public int compareTo(SmartCamera smartCamera) {
		if(batteryLife>smartCamera.batteryLife) {
			return 1;
		} else if(batteryLife == smartCamera.batteryLife) {
			return 0;
		} else {
			return -1;
		}
	}

	
}
