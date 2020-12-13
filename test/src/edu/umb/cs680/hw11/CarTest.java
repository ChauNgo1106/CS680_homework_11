package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CarTest {
	private static Car car1;
	private static Car car2;
	private static Car car3;
	private static Car car4;
	private static ArrayList<Car> usedCar = new ArrayList<>();

	@BeforeAll
	public static void setUp() {

		car1 = new Car("Lexus", "LS", 10000, 2008, 12500.5f);
		car2 = new Car("Toyota", "Camry", 4501, 2012, 15500.6f);
		car3 = new Car("Audi", "Q3", 2300, 2019, 35000.0f);
		car4 = new Car("Chevrolet", "Malibu", 8800, 2014, 21550.6f);

		usedCar.add(car1);
		usedCar.add(car2);
		usedCar.add(car3);
		usedCar.add(car4);

		// setting up the domination count initially.
		for (Car car : usedCar) {
			car.setDominationCount(car, usedCar);
		}
	}

	// helper method in purpose of getting of the car's make.
	public String[] convertArray(ArrayList<Car> usedCar) {
		ArrayList<String> temp = new ArrayList<String>();
		for (Car car : usedCar) {
			temp.add(car.getMake());
		}
		String[] result = new String[temp.size()];
		result = temp.toArray(result);
		return result;
	}

	// By Price
	@Test
	public void verify_the_order_of_car_by_price() {
		String[] expected = { "Audi", "Chevrolet", "Toyota", "Lexus" };

		Collections.sort(usedCar, (new Car()).new PriceComparator());
		assertArrayEquals(expected, convertArray(usedCar));
	}

	// By Mileage
	@Test
	public void verify_the_order_of_car_by_mileage() {
		String[] expected = { "Lexus", "Chevrolet", "Toyota", "Audi" };

		Collections.sort(usedCar, (new Car()).new MileageComparator());
		assertArrayEquals(expected, convertArray(usedCar));
	}

	// By Year
	@Test
	public void verify_the_order_of_car_by_year() {
		String[] expected = { "Lexus", "Toyota", "Chevrolet", "Audi" };

		Collections.sort(usedCar, (new Car()).new YearComparator());
		assertArrayEquals(expected, convertArray(usedCar));
	}

	// By Pareto's comparison
	@Test
	public void verify_the_order_of_car_by_using_Pareto_Comparison() {
		String[] expected = { "Audi", "Toyota", "Chevrolet", "Lexus" };
		Collections.sort(usedCar, (new Car().new ParetoComparator<Car>()));
		assertArrayEquals(expected, convertArray(usedCar));
	}
}
