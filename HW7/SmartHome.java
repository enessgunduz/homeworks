
//Muhammed Enes Gündüz - 150120038


import java.util.ArrayList;
import java.util.Arrays;

public class SmartHome {
	private ArrayList<SmartObject> smartObjectList = new ArrayList<>();
	
	public SmartHome() {
		
	}
	
	public boolean addSmartObject(SmartObject smartObject) {
		System.out.println("---------------------------------------------------------------------------\r\n" + 
				"---------------------------------------------------------------------------\r\n" + 
				"Adding new SmartObject\r\n" + 
				"---------------------------------------------------------------------------");
		String ip = "10.0.0."+(100+smartObjectList.size()); //Setting IP
		smartObject.connect(ip);
		smartObject.testObject(); //Testing object
		return smartObjectList.add(smartObject);
		
		
	}
	
	public boolean removeSmartObject(SmartObject smartObject) {
		return smartObjectList.remove(smartObject); //removing smartobject
	}
	
	public void controlLocation(boolean onCome) {
		System.out.println("---------------------------------------------------------------------------\r\n" + 
				"---------------------------------------------------------------------------\r\n" + 
				"LocationControl: OnCome\r\n" + 
				"---------------------------------------------------------------------------");
		for (SmartObject smartObject : smartObjectList) {
			if(smartObject instanceof LocationControl) { //If my object is a instance of LocationControl
				if(onCome) { 
					((LocationControl) smartObject).onCome(); 
				} else {
					((LocationControl) smartObject).onLeave();
				}
			}
		}
	}
	
	public void controlMotion(boolean hasMotion, boolean isDay) {
		System.out.println("---------------------------------------------------------------------------\r\n" + 
				"---------------------------------------------------------------------------\r\n" + 
				"MotionControl: HasMotion, isDay\r\n" + 
				"---------------------------------------------------------------------------");
		for (SmartObject smartObject : smartObjectList) {
			if(smartObject instanceof MotionControl) {
				((MotionControl) smartObject).controlMotion(hasMotion, isDay);
			}
		}
	}
	
	public void controlProgrammable() {
		System.out.println("---------------------------------------------------------------------------\r\n" + 
				"---------------------------------------------------------------------------\r\n" + 
				"Programmable: runProgram\r\n" + 
				"---------------------------------------------------------------------------");
		for (SmartObject smartObject : smartObjectList) {
			if(smartObject instanceof Programmable) {
				((Programmable) smartObject).runProgram();
			}
		}
	}
	
	public void controlTimer(int seconds) {
		System.out.println("---------------------------------------------------------------------------\r\n" + 
				"---------------------------------------------------------------------------\r\n" + 
				"Programmable: Timer = "+seconds+" seconds\r\n" + 
				"---------------------------------------------------------------------------");
		for (SmartObject smartObject : smartObjectList) {
			if(smartObject instanceof Programmable) {
				if(seconds>0) {
					((Programmable) smartObject).setTimer(seconds);
				} else if(seconds==0) {
					((Programmable) smartObject).cancelTimer();
				}
			}
		}
		
	}
	
	public void controlTimerRandomly() {
		System.out.println("---------------------------------------------------------------------------\r\n" + 
				"---------------------------------------------------------------------------\r\n" + 
				"Programmable: Timer = 5 or 10 seconds randomly\r\n" + 
				"---------------------------------------------------------------------------");
		for (SmartObject smartObject : smartObjectList) {
			if(smartObject instanceof Programmable) {
				int random = (int)(Math.random()*3); //Having a random number that has equal possibilities
				if(random == 1) {
					((Programmable) smartObject).setTimer(5);
				} else if (random == 2) {
					((Programmable) smartObject).setTimer(10);
				} else {
					((Programmable) smartObject).cancelTimer();
				}
			}
		}
	}
	
	public void sortCameras() {
		System.out.println("---------------------------------------------------------------------------\r\n" + 
				"---------------------------------------------------------------------------\r\n" + 
				"Sort Smart Cameras\r\n" + 
				"---------------------------------------------------------------------------");
		ArrayList<SmartCamera> cameras = new ArrayList<>(); //Creating list for cameras
		for (SmartObject smartObject : smartObjectList) {
			if(smartObject instanceof Comparable) {
				cameras.add((SmartCamera) smartObject); 
			}
		}
		SmartCamera[] camerasArr = cameras.toArray(new SmartCamera[cameras.size()]); //Filling all cameras in an array
		Arrays.sort(camerasArr); //Using Arrays.sort method thanks to Comparable interface
		for (int i = 0; i < camerasArr.length; i++) {
			System.out.println(camerasArr[i].toString());
		}
	}
	
}
