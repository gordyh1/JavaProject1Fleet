/*
 * Name : Gordon Hendry
 * Course: CSC 151 0002
 * Assignment: Final Project
 */

import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;

public class FleetGUI extends WidgetView {

	/*
	 * Create objects outside of constructor to use in inner classes which creates
	 * action listener and handles exceptions.
	 */

	Fleet fl = new Fleet();
	private JLabel carID;
	private JLabel carMile;
	private JLabel carFuel;
	private JLabel carCost;
	private JLabel carYear;
	private JTextField carJTF;
	private JTextField mileJTF;
	private JTextField fuelJTF;
	private JTextField costJTF;
	private JTextField yearJTF;
	private JButton jb;
	private int mileVal;
	private int fuelVal;
	private int costVal;
	private int yearVal;
	private String idVal;
	private JTextArea fleetString = new JTextArea();
	private JTextArea fleetStringMPG = new JTextArea();
	private JLabel flAvg = new JLabel("[Fleet avg MPG none");
	private JLabel bestMPG = new JLabel("[Best MPG none]");
	private JLabel bestMile = new JLabel("[Highest Mileage none]");
	private String[] petStrings = {"Mileage", "MPG", "Cost", "Year"};
	private JComboBox newBox = new JComboBox(petStrings);
	private JTextArea testArea = new JTextArea();
	

	WidgetView wv = new WidgetView();

	public FleetGUI() {

		// Create all of the swing objects required
		carID = new JLabel("new car ID");
		carMile = new JLabel("new car mileage");
		carFuel = new JLabel("new car fuel");
		carCost = new JLabel("new car cost");
		carYear = new JLabel("new car year");
		carJTF = new JTextField(10);
		mileJTF = new JTextField(5);
		fuelJTF = new JTextField(5);
		costJTF = new JTextField(5);
		yearJTF = new JTextField(4);

		// Create button to add car to fleet and add action listener
		jb = new JButton("Make a new car");
		jb.addActionListener(new ButtonEvent());
		newBox.addActionListener(new JComboEvent());

		// Add the objects to WidgetView
		wv.add(carID);
		wv.add(carJTF);
		wv.add(carMile);
		wv.add(mileJTF);
		wv.add(carFuel);
		wv.add(fuelJTF);
		wv.add(carCost);
		wv.add(costJTF);
		wv.add(carYear);
		wv.add(yearJTF);
		wv.add(jb);
		wv.add(fleetString);
		wv.add(fleetStringMPG);
		wv.add(bestMPG);
		wv.add(flAvg);
		wv.add(bestMile);
		wv.add(newBox);
		wv.add(testArea);
	}

	// Create class that manages button event. We are using elements of the
	// ActionListener interface
	// so we use "implements" rather than "extends".
	class ButtonEvent implements ActionListener {
		

		public void actionPerformed(ActionEvent e) {
			try {
				if (e.getActionCommand().equals("Make a new car")) {
					
					// Get the text from the text fields and trim whitespace.
					idVal = carJTF.getText().trim();
					mileVal = Integer.parseInt(mileJTF.getText().trim());
					fuelVal = Integer.parseInt(fuelJTF.getText().trim());
					costVal = Integer.parseInt(costJTF.getText().trim());
					yearVal = Integer.parseInt(yearJTF.getText().trim());
					
					
					// Create new Car object passing the user input as parameters
					Car car = new Car(idVal, mileVal, fuelVal, costVal, yearVal);
					// Add the car to the fleet class
					fl.add(car);

					fleetString.setText(fl.toString() + "\n");
					

					// flAvg.setText("Fleet avg MPG " + fl.getFleetAverageMPG());
					flAvg.setText(String.format("[Fleet avg MPG %.2f ]", fl.getFleetAverageMPG()));

					if (fl.size() >= 1) {
						bestMPG.setText("[Best MPG " + fl.highestMPG() + "]");
						bestMile.setText(("[Highest Mileage " + fl.highestMileage() + "]"));

					}

				}
				// Catch any NumberFormatException and displays a message asking for the correct
				// data type.
			} catch (NumberFormatException ex) {
				JLabel formatError = new JLabel("Please enter an int");
				wv.add(formatError);

			}

		}
	}

//https://stackoverflow.com/a/16339982  Looked up an example of how to use JComboBoxes and implemented to fit.
//https://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html
class JComboEvent implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JComboBox combo = (JComboBox)e.getSource();
		String currentSelection = (String) combo.getSelectedItem();
		if (currentSelection.equals("MPG")) {
			testArea.setText((fl.getSortedByMPGString()).toString());	
		}
		else if(currentSelection.equals("Cost")) {
			testArea.setText(fl.getSortedByCostString());
		}
		else if (currentSelection.equals("Year")) {
			testArea.setText(fl.getSortedByYearString());
		}
		else {
			testArea.setText(fl.getSortedByMileageString());
		}
	}
	
}

}
