package edu.umb.cs680.hw11;

import java.util.ArrayList;

import java.util.Comparator;

public class Car {

	private String make, model;
	private int mileage, year;
	private float price;
	private int dominationCount = 0;

	// default constructor
	public Car() {
	}

	// constructor with arguments
	public Car(String make, String model, int mileage, int year, float price) {
		super();
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.year = year;
		this.price = price;
	}

	public Car(String make, String model, int year) {
		this.make = make;
		this.model = model;
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public int getMileage() {
		return mileage;
	}

	public int getYear() {
		return year;
	}

	public float getPrice() {
		return price;
	}

	public int getDominationCount() {
		return this.dominationCount;
	}

	public void setDominationCount(Car car, ArrayList<Car> usedCar) {
		int counter = 0;
		for (Car cr : usedCar) {
			//compare those characteristics below of two cars, 
			// expensive price, older car, higher mileage will increase counter. 
			if ((Float.compare(car.getPrice(), cr.getPrice())) > 0) {
				counter++;
			}
			if ((Integer.compare(car.getYear(), cr.getYear())) < 0) {
				counter++;
			}
			if ((Integer.compare(car.getMileage(), cr.getMileage())) > 0) {
				counter++;
			}
			//means that at least two of three characteristics of a car is less dominant to another compared car 
			if (counter > 1) {
				this.dominationCount++;
				counter = 0;
			}
			counter = 0;

		}
	}

	// a class compares car's price, descending order
	public class PriceComparator implements Comparator<Car> {

		@Override
		public int compare(Car car1, Car car2) {

			return (int) (car2.getPrice() - car1.getPrice());
		}

	}

	// a class compares car's year, ascending order
	public class YearComparator implements Comparator<Car> {

		@Override
		public int compare(Car car1, Car car2) {

			return (int) (car1.getYear() - car2.getYear());
		}

	}

	// a class compares car's mileage, descending order
	public class MileageComparator implements Comparator<Car> {

		@Override
		public int compare(Car car1, Car car2) {

			return (int) (car2.getMileage() - car1.getMileage());
		}

	}

	@Override
	public String toString() {
		return "Car [make=" + make + ", model=" + model + ", mileage=" + mileage + ", year=" + year + ", price=" + price
				+ "]";
	}

	// a class compares car by using Pareto Comparison
	public class ParetoComparator<T> implements Comparator<Car> {

		@Override
		public int compare(Car car1, Car car2) {
			// bigger domination count will be less desired to buy
			return (int) (car1.getDominationCount() - car2.getDominationCount());
		}

	}

}
