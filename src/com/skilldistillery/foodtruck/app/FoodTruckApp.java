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
		app.foodTrucksMenu();

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
			System.out.print("Food Truck Rating as a number between 1 and 10: ");
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
	
	public void foodTrucksMenu () {
		System.out.println("Thank you. User input is complete."
				+ "\nPlease choose an option from the following menu");
		int entry = 0;
		do {
		System.out.println("1. List all existing food trucks.");
		System.out.println("2. See the average rating of food trucks.");
		System.out.println("3. Display the highest rated food truck.");
		System.out.println("4. Quit the program.");
		
		entry = kb.nextInt();
		
		switch (entry) {
		case 1:
			displayTrucks(getTrucks());
			break;
		case 2:
			System.out.println("The average Food Truck rating is :" + aveTruckRating(getTrucks()));
			break;
		case 3:
			displayTopTruck(getTrucks());
			break;
		case 4:
			quit();
			break;
		default:
			System.out.println("Invalid Entry. Please try again.");
			break;
		}
		
		} while (entry != 4);
	}

	private void quit() {
		System.out.println("Thank you. Have a nice day!");
		
	}

	private void displayTopTruck(FoodTruck[] foodTrucksCopy) {
		FoodTruck topTruck = new FoodTruck();
		topTruck.setRating(0);
		for (FoodTruck truck: foodTrucksCopy) {
			if(topTruck.getRating() < truck.getRating()) {
				topTruck = truck;
			}
			
		}
		topTruck.displayTruck();
		
	}

	private double aveTruckRating(FoodTruck[] foodTrucksCopy) {
		int ratingSum = 0;
		double ratingAve = 0.0;
		for(FoodTruck truck: foodTrucksCopy) {
			ratingSum += truck.getRating();
		}
		ratingAve = ratingSum/numOfTrucks;
		return ratingAve;
	}

	private FoodTruck[] getTrucks() {
		FoodTruck[] foodTrucksCopy = new FoodTruck[numOfTrucks];
		
		for (int idx = 0; idx < numOfTrucks; idx++) {
			foodTrucksCopy[idx] = foodTrucks[idx];
		}
		return foodTrucksCopy;
		
	}

	private void displayTrucks(FoodTruck[] foodTrucksCopy) {
		for (FoodTruck truck : foodTrucksCopy ) {
			truck.displayTruck();
		}
		
	}
}
