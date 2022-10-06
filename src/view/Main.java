package view;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import model.Elevator;

public class Main {
	
	
	/**
	 * 
	 */
	private static Hashtable<Integer, Integer> floorRequests;
	
	/**
	 * 
	 */
	private static Elevator first_elevator;
	
	
	
	/**
	 * 
	 */
	private static void initialSetup() {
		floorRequests = new Hashtable<Integer, Integer>();
		floorRequests.put(5, 2);
		floorRequests.put(29, 10);
		floorRequests.put(13, 1);
		floorRequests.put(10, 1);
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(10);
		list.add(1);
		list.add(1);
		
		first_elevator = new Elevator(4, list);
	}
	
	
	
	/**
	 * 
	 */
	private static void iteration() {
		
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		initialSetup();
	}

}
