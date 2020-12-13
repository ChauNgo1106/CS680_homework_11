package edu.umb.cs680.hw11;

import java.util.ArrayList;
import java.util.Collections;

public class mainClass {

	public static void main(String[] args) {
		
		Car car1 = new Car("Lexus", "LS", 10000, 2008, 12500.5f);
		Car car2 = new Car("Toyota", "Camry", 4501, 2012, 15500.6f);
		Car car3 = new Car("Audi", "Q3", 2300, 2019, 35000.0f);
		Car car4 = new Car("Chevrolet", "Malibu", 8800, 2014, 21550.6f);
		ArrayList<Car> usedCar = new ArrayList<>();

		usedCar.add(car1);
		usedCar.add(car2);
		usedCar.add(car3);
		usedCar.add(car4);

		System.out.println("Used cars information");
		System.out.println(car1.toString());
		System.out.println(car2.toString());
		System.out.println(car3.toString());
		System.out.println(car4.toString());
		System.out.println();

		System.out.println("Sorted by Price (Descending order)");
		Collections.sort(usedCar, new Car().new PriceComparator());
		for (Car car : usedCar) {
			System.out.println(car.getMake());
		}
		System.out.println();

		System.out.println("Sorted by Year (Ascending order)");
		Collections.sort(usedCar, new Car().new YearComparator());
		for (Car car : usedCar) {
			System.out.println(car.getMake());
		}
		System.out.println();

		System.out.println("Sorted by Mileage (Descending order)");
		Collections.sort(usedCar, new Car().new MileageComparator());
		for (Car car : usedCar) {
			System.out.println(car.getMake());
		}
		System.out.println();

		for (Car car : usedCar) {
			car.setDominationCount(car, usedCar);
		}
		System.out.println();
		System.out.println("Sorted by using Pareto. The best car will print first.");
		Collections.sort(usedCar, new Car().new ParetoComparator<Car>());
		for (Car car : usedCar) {
			System.out.println(car.getMake());
		}
	}

}
