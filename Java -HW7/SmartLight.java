//Muhammed Enes Gündüz - 150120038


import java.util.Calendar;

public class SmartLight extends SmartObject implements LocationControl, Programmable {
	private boolean hasLightTurned = false;
	private Calendar programTime;
	private boolean programAction;
	
	//Setting variables
	public SmartLight(String alias, String macId) {
		setAlias(alias);
		setMacId(macId);
	}
	
	public void turnOnLight() {
		if(controlConnection()) {
			if(!hasLightTurned) {
				hasLightTurned = true;
				Calendar current = Calendar.getInstance(); //Getting current time
				System.out.println("Smart Light - " + getAlias()+ " is turned on now (Current time: "+ current.get(11)+":"+current.get(12)+":"+current.get(13)+")");
			} else {
				System.out.println("Smart Light - " + getAlias()+ " has been already turned on");
			}
		} 
	}
	
	public void turnOffLight() {
		if(controlConnection()) {
			if(hasLightTurned) {
				hasLightTurned = false;
				Calendar current = Calendar.getInstance();
				System.out.println("Smart Light - " + getAlias()+ " is turned off now (Current time: "+ current.get(11)+":"+current.get(12)+":"+current.get(13)+")");
			} else {
				System.out.println("Smart Light - " + getAlias()+ " has been already turned off");
			}
		} 
	}
	
	//Testing the functionality of object
	public boolean testObject() {
		if(controlConnection()) {
			System.out.println("Test is starting for SmartLight");
			SmartObjectToString();
			turnOnLight();
			turnOffLight();
			System.out.println("Test completed for SmartLight\n\n");
			return true;
		} else {
			return false;
		}
	}
	
	
	public boolean shutDownObject() {
		if(controlConnection()) {
			SmartObjectToString();
			if(hasLightTurned) {
				turnOffLight();
			}
			return true;
		}else {
			return false;
		}
	}
	
	public void onLeave() {
		if(controlConnection()) {
			System.out.println("On Leave -> Smart Light - "+ getAlias());
			turnOffLight();
		}
	}
	
	public void onCome() {
		if(controlConnection()) {
			System.out.println("On Come -> Smart Light - "+ getAlias());
			turnOnLight();
		}
	}
	
	public void setTimer(int seconds) {
		if(controlConnection()) {
			programTime = Calendar.getInstance();
			programTime.add(13, seconds); //Setting programTime calendar instance for holding our execute time
			Calendar crn = Calendar.getInstance();
			if(hasLightTurned) {
				System.out.println("Smart light - "+getAlias()+" will be turned off "+ seconds+" seconds later! (Current time: "+ crn.get(11)+":"+crn.get(12)+":"+crn.get(13)+")");
				programAction = true;
			}
			else {
				System.out.println("Smart light - "+getAlias()+" will be turned on "+ seconds+" seconds later! (Current time: "+ crn.get(11)+":"+crn.get(12)+":"+crn.get(13)+")");
				programAction = true;
			}
		}
	}
	
	public void cancelTimer() {
		if(controlConnection()) {
			programTime = null;
		}
	}
	
	public void runProgram() {
		if(controlConnection()) {
			if(programAction) {
				Calendar crn = Calendar.getInstance();
				//If all time parameters of current time and programTime is equal, then execute 
				if(programTime.get(11) == crn.get(11) && programTime.get(12) == crn.get(12) && programTime.get(13) == crn.get(13) && !hasLightTurned) {
					System.out.println("RunProgram -> Smart Light - "+ getAlias());
					turnOnLight();
				} else if (programTime.get(11) == crn.get(11) && programTime.get(12) == crn.get(12) && programTime.get(13) == crn.get(13) && hasLightTurned) {
					System.out.println("RunProgram -> Smart Light - "+ getAlias());
					turnOffLight();
				}
				programTime = null;
				programAction = false;
			}
			
		}
	}
	
	
}
