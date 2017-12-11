import java.util.ArrayList;
import java.text.*;
import java.util.Arrays;

public class Fleet extends Car {

	private ArrayList<Car> myCars;

	public Fleet() {
		myCars = new ArrayList<>();
	}

	public Car find(String identifier) {
		for (Car c : myCars) {
			if (c.getIdentifier().equals(identifier)) {
				return c;
			}
		}
		return null;
	}

	public boolean add(Car carToAdd) {
		return myCars.add(carToAdd);
	}

	public int size() {
		return myCars.size();
	}

	public Car get(int position) {
		return myCars.get(position);
	}

	public int getTotalMiles() {
		int totalMiles = 0;
		for (Car c : myCars) {
			totalMiles += c.getMiles();
		}
		return totalMiles;
	}

	public int getTotalFuel() {
		int totalFuel = 0;
		for (Car c : myCars) {
			totalFuel += c.getFuelUsed();
		}
		return totalFuel;
	}

	public double getCarAverageMPG() {
		if (size() == 0)
			return -1;
		double totMPG = 0;
		for (Car c : myCars) {
			totMPG += c.getMPG();
		}
		return totMPG / myCars.size();
	}

	public double getFleetAverageMPG() {
		if (getTotalFuel() == 0)
			return -1;
		return (double) getTotalMiles() / getTotalFuel();
	}

	@Override
	public String toString() {
		String s = "Fleet [\n";
		for (Car c : myCars) {
			s += c.toString() + "\n";
		}
		s += "] \n";
		return s;
	}

	// from Liang Ch 07
	private void selectionSortMPG(ArrayList<Car> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			// Find the minimum in the list[i..list.length-1]
			Car currentMin = list.get(i);
			int currentMinIndex = i;

			for (int j = i + 1; j < list.size(); j++) {
				if (currentMin.getMPG() > list.get(j).getMPG()) {
					currentMin = list.get(j);
					currentMinIndex = j;
				}
			}

			// Swap list[i] with list[currentMinIndex] if necessary;
			if (currentMinIndex != i) {
				list.set(currentMinIndex, list.get(i));
				list.set(i, currentMin);
			}
		}
	}
	
	public ArrayList<Car> getSortedByMPG() {
		ArrayList<Car> newList = new ArrayList<>(myCars);
		selectionSortMPG(newList);
		return newList;
	}
	
	private void selectionSortYear(ArrayList<Car> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			// Find the minimum in the list[i..list.length-1]
			Car currentMin = list.get(i);
			int currentMinIndex = i;

			for (int j = i + 1; j < list.size(); j++) {
				if (currentMin.getYear() > list.get(j).getYear()) {
					currentMin = list.get(j);
					currentMinIndex = j;
				}
			}

			// Swap list[i] with list[currentMinIndex] if necessary;
			if (currentMinIndex != i) {
				list.set(currentMinIndex, list.get(i));
				list.set(i, currentMin);
			}
		}
	}
	
	private void selectionSortCost(ArrayList<Car> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			// Find the minimum in the list[i..list.length-1]
			Car currentMin = list.get(i);
			int currentMinIndex = i;

			for (int j = i + 1; j < list.size(); j++) {
				if (currentMin.getCost() > list.get(j).getCost()) {
					currentMin = list.get(j);
					currentMinIndex = j;
				}
			}

			// Swap list[i] with list[currentMinIndex] if necessary;
			if (currentMinIndex != i) {
				list.set(currentMinIndex, list.get(i));
				list.set(i, currentMin);
			}
		}
	}
	
	public ArrayList<Car> getSortedByCost() {
		ArrayList<Car> newList = new ArrayList<Car>(myCars);
		selectionSortCost(newList);
		return newList;
	}
	
	public ArrayList<Car> getSortedByYear() {
		ArrayList<Car> newList = new ArrayList<Car>(myCars);
		selectionSortYear(newList);
		return newList;
	}
	
	



	public String highestMPG() {
		ArrayList<Car> newList = new ArrayList<Car>(myCars);
		selectionSortMPG(newList);
		Car car1 = newList.get(newList.size() - 1);
		return car1.getIdentifier();

	}

	public String highestMileage() {
		ArrayList<Car> newList = new ArrayList<Car>(myCars);
		// Use Selection sort on the list to order by MPG. Utilize ArrayList.get method
		// to get object at given index.
		for (int i = 0; i < newList.size() - 1; i++) {
			Car currentMin = (Car) newList.get(i);
			int currentMinIndex = i;

			for (int j = i + 1; j < newList.size(); j++) {
				if (currentMin.compareMiles((Car) newList.get(j)) > 0) {
					currentMin = (Car) newList.get(j);
					currentMinIndex = j;
				}
			}
			// use ArrayList.set to replace the value at i with the currentMin
			if (currentMinIndex != i) {
				newList.set(i, currentMin);

			}
		}

		Car car1 = newList.get(newList.size() - 1);
		return car1.getIdentifier();
	}
	
	

}
