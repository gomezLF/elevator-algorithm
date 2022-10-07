package model;

import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;

public class Elevator {
	
	/**
	 * 
	 */
	private ElevatorDirection elevatorDirection;
	
	/**
	 * 
	 */
	private int currentFloor;
	
	/**
	 * 
	 */
	private List<Integer> floorsEntered;
	
	
	/**
	 * 
	 */
	private Hashtable<Integer, Integer> floorRequest;
	
	
	
	/**
	 * 
	 * @param initialFloor
	 * @param floorsEntered
	 */
	public Elevator(int initialFloor, List<Integer> floorsEntered) {
		this.currentFloor = initialFloor;
		this.floorsEntered = floorsEntered;
		this.floorRequest = new Hashtable<Integer, Integer>();
		
		calculateElevatorDirection();
	}



	/**
	 * @return the floorList
	 */
	public Hashtable<Integer, Integer> getFloorRequest() {
		return floorRequest;
	}



	/**
	 * @param floorList the floorList to set
	 */
	public void setFloorRequest(Hashtable<Integer, Integer> floorList) {
		this.floorRequest = floorList;
	}



	/**
	 * @return the elevatorDirection
	 */
	public ElevatorDirection getElevatorDirection() {
		return elevatorDirection;
	}



	/**
	 * @param elevatorDirection the elevatorDirection to set
	 */
	public void setElevatorDirection(ElevatorDirection elevatorDirection) {
		this.elevatorDirection = elevatorDirection;
	}



	/**
	 * @return the currentFloor
	 */
	public int getCurrentFloor() {
		return currentFloor;
	}



	/**
	 * @param currentFloor the currentFloor to set
	 */
	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}



	/**
	 * @return the floorsEntered
	 */
	public List<Integer> getFloorsEntered() {
		return floorsEntered;
	}



	/**
	 * @param floorsEntered the floorsEntered to set
	 */
	public void setFloorsEntered(List<Integer> floorsEntered) {
		this.floorsEntered = floorsEntered;
	}
	
	
	
	/**
	 * 
	 */
	public void calculateElevatorDirection() {
		if(floorsEntered.get(0) > currentFloor) {
			setElevatorDirection(ElevatorDirection.ASCENDING);
			
		}else if(floorsEntered.get(0) < currentFloor) {
			setElevatorDirection(ElevatorDirection.DESCENDING);
			
		}else {
			setElevatorDirection(ElevatorDirection.IMMOBILE);
		}
		
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public boolean checkArriveToDestination() {
		boolean isFloorDestination = false;
		
		if(floorRequest.contains(currentFloor)) {
			deleteRequestFloor();
			deleteRegisteredFloor();
			isFloorDestination = true;
		}
		
		return isFloorDestination;
	}
	
	
	
	/**
	 * 
	 */
	private void deleteRequestFloor() {
		for (Entry<Integer, Integer> value : floorRequest.entrySet()) {
			if(currentFloor == value.getValue()) {
				floorRequest.remove(value.getKey());
				break;
			}
			
		}
	}
	
	
	
	/**
	 * 
	 */
	private void deleteRegisteredFloor() {
		for (int i = 0; i < floorsEntered.size(); i++) {
			if(currentFloor == floorsEntered.get(i)) {
				floorsEntered.remove(i);
			}
		}
	}
	
	
	
	/**
	 * 
	 */
	public void changeFloor() {
		if(!floorsEntered.isEmpty()) {
			calculateElevatorDirection();
			
			if(elevatorDirection == ElevatorDirection.ASCENDING) {
				currentFloor++;
				
			}else if(elevatorDirection == ElevatorDirection.DESCENDING){
				currentFloor--;
			}
		}
	}
	
	
	
}
