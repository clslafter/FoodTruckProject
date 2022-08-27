package com.skilldistillery.foodtruck.app;

import com.skilldistillery.foodtruck.entities.FoodTruck;
import java.util.Scanner;

public class FoodTruckApp {

	Scanner kb = new Scanner(System.in);

	final int MAX_TRUCKS = 5;
	int numOfTrucks = 0;
	FoodTruck[] foodTrucks = new FoodTruck[MAX_TRUCKS];

	public static void main(String[] args) {

		FoodTruckApp app = new FoodTruckApp();
		
		app.inputFoodTrucks();

	}

	public void inputFoodTrucks() {

		while (numOfTrucks < MAX_TRUCKS) {
			System.out.println("Please enter the Food Truck information."
					+ "\nTo quit, type quit when prompted for the name");
			System.out.print("Food Truck Name: ");
			String name = kb.next();
			if(name.equalsIgnoreCase("quit")) {
				break;
			}
			System.out.print("Food Truck Type: ");
			String type = kb.next();
			System.out.print("Food Truck Rating: ");
			int rating = kb.nextInt();
			
			FoodTruck truck = new FoodTruck(name, type, rating);
			
			addTruck(truck);
			
		}
		

	}
	
	public void addTruck (FoodTruck truck) {
		if (numOfTrucks < MAX_TRUCKS) {
			foodTrucks[numOfTrucks] = truck;
			numOfTrucks++;
			}
	}
}
