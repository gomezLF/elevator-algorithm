package view;

import java.util.ArrayList;
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
	private static List<Integer> floorEntered;
	
	/**
	 * 
	 */
	private static Elevator first_elevator;
	
	
	
	/**
	 * 
	 */
	private static void initialSetup() {
		 sc = new Scanner(System.in);
		
		floorEntered = new ArrayList<Integer>();
		floorEntered.add(5);
		floorEntered.add(29);
		floorEntered.add(13);
		floorEntered.add(10);
		
		first_elevator = new Elevator(1, floorEntered);
	}
	
	
	/**
	 * 
	 * @param newFloor
	 * @param floorToGo
	 * @param elevator
	 */
	private static void addFloorToList(int newFloor, int floorToGo, Elevator elevator) {
		floorEntered.add(newFloor);
		elevator.setFloorsEntered(floorEntered);
		
		if(floorToGo > 0) {
			elevator.getFloorList().put(elevator.getCurrentFloor(), floorToGo);
			floorEntered.add(floorToGo);
			elevator.setFloorsEntered(floorEntered);
		}
		
		
	}
	
	
	/***
	 * 
	 * @param elevator
	 */
	private static void iteration(Elevator elevator) {
		boolean stop = false;
		String request = "";
		int newFloor = 0;
		int floorEntered = 0;
		
		
		while(!elevator.getFloorsEntered().isEmpty()) {
			System.out.println("====================");
			System.out.println("Piso actual = " + elevator.getCurrentFloor());
			System.out.println("Dirección del elevador = " + elevator.getElevatorDirection());
			System.out.println("Pisos seleccionados = " + elevator.getFloorsEntered());
			
			System.out.println("");
			System.out.println("¿Quiere pedir el elevador? Si es así, escriba el caracter 'y', de lo contrario escriba 'n'");
			request = sc.nextLine();
			
			if(request.compareToIgnoreCase("y") == 0) {
				System.out.println("Por favor entre el número del piso en el que se encuentra");
				newFloor = sc.nextInt();
				sc.nextLine();
				
				addFloorToList(newFloor, 0, elevator);
			}
			
			if(elevator.checkArriveToDestination()) {
				if(elevator.getFloorList().containsValue(elevator.getCurrentFloor()) || elevator.getFloorList().isEmpty()) {
					System.out.println("Elevador se detiene");
					System.out.println("Arrivo al destino, piso " + elevator.getCurrentFloor());
					
				}else {
					System.out.println("Por favor entre el número del piso al cual quiere dirigirse");
					floorEntered = sc.nextInt();
					sc.nextLine();
					
					addFloorToList(0, floorEntered, elevator);
				}
				
			}else {
				System.out.println("Elevador " + elevator.getElevatorDirection() + ", del piso " + elevator.getCurrentFloor() + "al " + elevator.getFloorsEntered().get(0));
			}
			
		}
			
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		initialSetup();
		iteration(first_elevator);
	}

}
