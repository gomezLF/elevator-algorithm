package view;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

import model.Elevator;

public class Main {
	
	
	/**
	 * 
	 */
	private static Scanner sc;
	
	/**
	 * 
	 */
	private static Elevator elevator;
	
	
	
	/**
	 * 
	 */
	private static void initialSetup() {
		 sc = new Scanner(System.in);
		 String values = "";
		 int initialFloor = 0;
		 
		 System.out.println("Digite los valores de los pisos con los cuales quiere comenzar, digite los valores separados por comas");
		 values = sc.nextLine();
		 
		 System.out.println("");
		 System.out.println("Digite a continuación el valor del piso inicial");
		 initialFloor = sc.nextInt();
		 sc.nextLine();
		 
		 
		 
		//Here the string is converted to a number, to form the initial floor list and initial floors request.
		 String[] data = values.split(",");
		 List<Integer> initialFloors = new ArrayList<Integer>();
		 Hashtable<Integer, Integer> floorRequest = new Hashtable<>();
		 
		 for (int i = 0; i < data.length; i++) {
			initialFloors.add(Integer.parseInt(data[i]));
			floorRequest.put(initialFloor, Integer.parseInt(data[i]));
		}
		
		elevator = new Elevator(initialFloor, initialFloors);
		elevator.setFloorRequest(floorRequest);
		
	}
	
	
	/**
	 * 
	 * @param newFloor
	 * @param elevator
	 */
	private static void addFloorToList(int newFloor, Elevator elevator) {
		elevator.getFloorRequest().put(elevator.getCurrentFloor(), newFloor);
		elevator.getFloorsEntered().add(newFloor);
		elevator.calculateElevatorDirection();
	}
	
	
	/**
	 * 
	 * @return
	 */
	private static boolean checkArriveToDestination() {
		boolean arrived = elevator.checkArriveToDestination();
		
		if(arrived) {
			System.out.println("");
			System.out.println("Elevador se detiene");
			System.out.println("Arrivo al destino, piso " + elevator.getCurrentFloor());
		}else {
			System.out.println("");
			System.out.println("Elevador " + elevator.getElevatorDirection() + ", al piso " + elevator.getFloorsEntered().get(0));
		}
		
		return arrived;
	}
	
	
	/***
	 * 
	 * @param elevator
	 */
	private static void iteration(Elevator elevator) {
		String request = "";
		int newFloor = 0;
		
		while(!elevator.getFloorsEntered().isEmpty()) {
			//elevator.calculateElevatorDirection();
			
			System.out.println("====================");
			System.out.println("Piso actual = " + elevator.getCurrentFloor());
			System.out.println("Dirección del elevador = " + elevator.getElevatorDirection());
			System.out.println("Pisos seleccionados = " + elevator.getFloorsEntered());
			
			checkArriveToDestination();
			
			System.out.println("");
			System.out.println("¿Quiere pedir el elevador? Si es así, escriba el caracter 'y', de lo contrario escriba 'n'");
			request = sc.nextLine();
			
			if(request.compareToIgnoreCase("y") == 0) {
				System.out.println("");
				System.out.println("Por favor digite el número del piso al cual quiere llegar");
				newFloor = sc.nextInt();
				sc.nextLine();
				
				addFloorToList(newFloor, elevator);
				checkArriveToDestination();	
			}
			
			elevator.changeFloor();
		}
			
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		initialSetup();
		iteration(elevator);
	}

}
