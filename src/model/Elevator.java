package model;

import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

public class Elevator {
	
	/**
	 * 
	 */
	private int initialFloor;
	
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
	private Hashtable<Integer, Integer> floorList;
	
	
	
	/**
	 * 
	 * @param initialFloor
	 * @param floorsEntered
	 */
	public Elevator(int initialFloor, List<Integer> floorsEntered) {
		this.initialFloor = initialFloor;
		this.currentFloor = initialFloor;
		this.floorsEntered = floorsEntered;
		this.floorList = new Hashtable<Integer, Integer>();
		this.elevatorDirection = elevatorDirection.IMMOBILE;
	}



	/**
	 * @return the floorList
	 */
	public Hashtable<Integer, Integer> getFloorList() {
		return floorList;
	}



	/**
	 * @param floorList the floorList to set
	 */
	public void setFloorList(Hashtable<Integer, Integer> floorList) {
		this.floorList = floorList;
	}



	/**
	 * @return the initialFloor
	 */
	public int getInitialFloor() {
		return initialFloor;
	}



	/**
	 * @param initialFloor the initialFloor to set
	 */
	public void setInitialFloor(int initialFloor) {
		this.initialFloor = initialFloor;
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
		calculateElevatorDirection();
	}
	
	
	private void calculateElevatorDirection() {
		if(floorsEntered.get(0) > currentFloor) {
			setElevatorDirection(elevatorDirection.ASCENDING);
			Collections.sort(this.floorsEntered);
			
		}else if(floorsEntered.get(0) < currentFloor) {
			setElevatorDirection(elevatorDirection.DESCENDING);
			Collections.sort(this.floorsEntered, Collections.reverseOrder());
			
		}else {
			setElevatorDirection(elevatorDirection.IMMOBILE);
		}
		
	}
	
	public boolean checkArriveToDestination() {
		boolean isFloorDestination = false;
		
		if(currentFloor == floorsEntered.get(0)) {
			isFloorDestination = true;
		}
		
		return isFloorDestination;
	}
	
	public void changeFloor() {
		
	}
	
	
	
}
