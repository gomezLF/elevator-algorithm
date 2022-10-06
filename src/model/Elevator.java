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
	
	
	
}
