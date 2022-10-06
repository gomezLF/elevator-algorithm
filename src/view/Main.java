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
		 
		 
		 
		//Here the string is converted to a number, to form the initial floor list.
		 String[] data = values.split(",");
		 List<Integer> initialFloors = new ArrayList<Integer>();
		 
		 for (int i = 0; i < data.length; i++) {
			initialFloors.add(Integer.parseInt(data[i]));
		}
		
		elevator = new Elevator(initialFloor, initialFloors);
	}
	
	
	/**
	 * 
	 * @param newFloor
	 * @param floorToGo
	 * @param elevator
	 */
	private static void addFloorToList(int newFloor, int floorToGo, Elevator elevator) {
		elevator.getFloorsEntered().add(newFloor);
		elevator.calculateElevatorDirection();
		
		if(floorToGo > 0) {
			elevator.getFloorList().put(elevator.getCurrentFloor(), floorToGo);
			elevator.getFloorsEntered().add(floorToGo);
			elevator.calculateElevatorDirection();
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
		iteration(elevator);
		
		System.out.println(elevator.getInitialFloor());
	}

}
