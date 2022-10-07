package model;

import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;

public class Elevator {
	
	/**
	 * Parameter to indicate the direction in which the elevator moves.
	 */
	private ElevatorDirection elevatorDirection;
	
	/**
	 * Parameter indicating the current floor on which the elevator is located.
	 */
	private int currentFloor;
	
	/**
	 * List of floors to which the elevator has to reach, 
	 * according to the direction in which it moves.
	 */
	private List<Integer> floorsEntered;
	
	
	/**
	 * List of floor requests, with their requested floors, 
	 * which the elevator has to reach.
	 */
	private Hashtable<Integer, Integer> floorRequest;
	
	
	
	/**
	 * Constructor of the Elevator class, in which its corresponding parameters are 
	 * initialized.
	 * 
	 * @param initialFloor - The initial floor from which the elevator is to start operating on the first run.
	 * @param floorsEntered - List of floors to which the elevator has to reach, according to the direction in which it moves.
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
	 * Method that calculates the direction of the elevator, according to the oldest 
	 * order, i.e. the first or closest to be executed.
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
	 * Method that identifies whether the current floor on which the elevator is 
	 * located is a previously named floor. If so, it removes the floor from both the 
	 * requests and the floor list.
	 * 
	 * @return true if the current floor was previously called, false otherwise.
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
	 * Method that removes the current floor on which the elevator is located from 
	 * the list of requested floors.
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
	 * Method that removes the current floor on which the elevator is located from 
	 * the list of floors to which it has to move.
	 */
	private void deleteRegisteredFloor() {
		for (int i = 0; i < floorsEntered.size(); i++) {
			if(currentFloor == floorsEntered.get(i)) {
				floorsEntered.remove(i);
			}
		}
	}
	
	
	
	/**
	 * Method that allows changing floors, depending on the direction in 
	 * which the elevator moves.
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
