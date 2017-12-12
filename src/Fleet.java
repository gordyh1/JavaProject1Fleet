/*
 * Name : Gordon Hendry
 * Course: CSC 151 0002
 * Assignment: Final Project
 */

import java.util.ArrayList;
import java.text.*;
import java.util.Arrays;



public class Fleet extends Car {

	private ArrayList<Car> myCars;

	//Constructor creates empty Fleet
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

	//Add cars to the Fleet
	public boolean add(Car carToAdd) {
		return myCars.add(carToAdd);
	}

	//Returns size of Fleet
	public int size() {
		return myCars.size();
	}

	//Returns car at given index
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
	
	public String getSortedByMPGString() {
		ArrayList<Car> newList = new ArrayList<>(myCars);
		
		selectionSortMPG(newList);
		String s = "Fleet [\n";
		for (Car c : newList) {
			s += c.toString() + "\n";
		}
		s += "] \n";
		return s;
		
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
	
	private void selectionSortMileage(ArrayList<Car> list) {
		 
			for (int i = 0; i < list.size() - 1; i++) {
				// Find the minimum in the list[i..list.length-1]
				Car currentMin = list.get(i);
				int currentMinIndex = i;

				for (int j = i + 1; j < list.size(); j++) {
					if (currentMin.getMiles() > list.get(j).getMiles()) {
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
	
	public String getSortedByCostString() {
		ArrayList<Car> newList = new ArrayList<>(myCars);
		selectionSortCost(newList);
		String s = "Fleet [\n";
		for (Car c : newList) {
			s += c.toString() + "\n";
		}
		s += "] \n";
		return s;
		
	}
	
	//Utilize selection sort by year and return the new sorted list
	public ArrayList<Car> getSortedByYear() {
		ArrayList<Car> newList = new ArrayList<Car>(myCars);
		selectionSortYear(newList);
		return newList;
	}
	
	//Utilize selection sort by year and then iterate over the new list to return ordered string
	public String getSortedByYearString() {
		ArrayList<Car> newList = new ArrayList<>(myCars);
		selectionSortYear(newList);
		String s = "Fleet [\n";
		for (Car c : newList) {
			s += c.toString() + "\n";
		}
		s += "] \n";
		return s;
		
	}
	
	//Utilize selection sort by mpg method to find the highest mpg
	public String highestMPG() {
		ArrayList<Car> newList = new ArrayList<Car>(myCars);
		selectionSortMPG(newList);
		Car car1 = newList.get(newList.size() - 1);
		return car1.getIdentifier();
	}

	//Utilize selection sort by mpg method to find the highest mileage
	public String highestMileage() {
		ArrayList<Car> newList = new ArrayList<Car>(myCars);
		selectionSortMileage(newList);
		Car car1 = newList.get(newList.size() - 1);
		return car1.getIdentifier();
	}
	
	public String getSortedByMileageString() {
		ArrayList<Car> newList = new ArrayList<Car>(myCars);
		selectionSortMileage(newList);
		String s = "Fleet [\n";
		for (Car c : newList) {
			s += c.toString() + "\n";
		}
		s += "] \n";
		return s;
	}
	

}
