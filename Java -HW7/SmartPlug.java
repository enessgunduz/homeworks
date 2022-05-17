//Muhammed Enes Gündüz - 150120038

import java.util.Calendar;

public class SmartPlug extends SmartObject implements Programmable{
	private boolean status;
	private Calendar programTime;
	private boolean programAction;
	
	public SmartPlug(String alias, String macId) {
		setAlias(alias);
		setMacId(macId);
	}
	
	
	public void turnOn() {
		if(controlConnection()) {
			if(!status) {
				status = true;
				Calendar current = Calendar.getInstance();
				System.out.println("Smart Plug - "+ getAlias()+ " is turned on now (Current time: "+ current.get(11)+":"+current.get(12)+":"+current.get(13)+")");
			} else {
				System.out.println("Smart Plug - "+getAlias()+ " has been already turned on");
			}
		}
	}
	
	public void turnOff() {
		if(controlConnection()) {
			if(status) {
				status = false;
				Calendar current = Calendar.getInstance();
				System.out.println("Smart Plug - "+ getAlias()+ " is turned off now (Current time: "+ current.get(11)+":"+current.get(12)+":"+current.get(13)+")");
			} else {
				System.out.println("Smart Plug - "+getAlias()+ " has been already turned off");
			}
		}
	}
	
	public boolean testObject() {
		if(controlConnection()) {
			System.out.println("Test is starting for SmartPlug");
			SmartObjectToString();
			turnOn();
			turnOff();
			System.out.println("Test completed for SmartPlug");
			return true;
		} else {
			return false;
		}
	}
	
	public boolean shutDownObject() {
		if(controlConnection()) {
			SmartObjectToString();
			if(status) {
				turnOff();
			}
			return true;
		}else {
			return false;
		}
	}
	
	public void setTimer(int seconds) {
		if(controlConnection()) {
			programTime = Calendar.getInstance();
			programTime.add(13, seconds);
			Calendar crn = Calendar.getInstance();
			if(status) {
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
				if(programTime.get(11) == crn.get(11) && programTime.get(12) == crn.get(12) && programTime.get(13) == crn.get(13) && !status) {
					System.out.println("RunProgram -> Smart Light - "+ getAlias());
					turnOn();
					programTime = null;
					programAction = false;
				} else if (programTime.get(11) == crn.get(11) && programTime.get(12) == crn.get(12) && programTime.get(13) == crn.get(13) && status) {
					System.out.println("RunProgram -> Smart Light - "+ getAlias());
					turnOff();
					programTime = null;
					programAction = false;
				}
				
			}
			
		}
	}
	
	
}
