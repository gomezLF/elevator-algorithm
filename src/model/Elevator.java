package model;

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
	 * @param initialFloor
	 * @param floorsEntered
	 */
	public Elevator(int initialFloor, List<Integer> floorsEntered) {
		this.initialFloor = initialFloor;
		this.floorsEntered = floorsEntered;
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
		
		if(initialFloor < floorsEntered.get(0) || currentFloor < floorsEntered.get(0)) {
			elevatorDirection = elevatorDirection.ASCENDING;
		}else {
			elevatorDirection = elevatorDirection.DESCENDING;
		}
		
	}
	
	
	
	
	
	
}
