package com.skilldistillery.foodtruck.entities;

public class FoodTruck {

	private int id;
	private String name;
	private String type;
	private int rating;
	private static int numOfFoodTrucks = 0;

	public FoodTruck(String ftName, String ftType, int ftRating) {
		name = ftName;
		type = ftType;
		rating = ftRating;

//		assign Food Truck Id Number and increment
		id = ++numOfFoodTrucks;
	}
	
	public FoodTruck() {
		
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public double getRating() {
		return rating;
	}
	
	public void displayTruck() {
		String truckData = toString();
		System.out.println(truckData);
	}

	@Override
	public String toString() {
		StringBuilder foodTruckInfo = new StringBuilder();
		foodTruckInfo.append("Food Truck ID: ").append(id).append("\nFood Truck Name: ").append(name)
				.append("\nFood Truck Type: ").append(type).append("\nFood Truck Rating: ").append(rating);

		return foodTruckInfo.toString();
	}

}
