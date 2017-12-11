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
	private JTextField carJTF;
	private JTextField mileJTF;
	private JTextField fuelJTF;
	private JButton jb;
	private int mileVal;
	private int fuelVal;
	private String idVal;
	private JTextArea fleetString = new JTextArea();
	private JTextArea fleetStringMPG = new JTextArea();
	private JLabel flAvg = new JLabel("[Fleet avg MPG none");
	private JLabel bestMPG = new JLabel("[Best MPG none]");
	private JLabel bestMile = new JLabel("[Highest Mileage none]");
	

	WidgetView wv = new WidgetView();

	public FleetGUI() {

		// Create all of the swing objects required
		carID = new JLabel("new car ID");
		carMile = new JLabel("new car mileage");
		carFuel = new JLabel("new car fuel");
		carJTF = new JTextField(10);
		mileJTF = new JTextField(5);
		fuelJTF = new JTextField(5);

		// Create button to add car to fleet and add action listener
		jb = new JButton("Make a new car");
		jb.addActionListener(new ButtonEvent());

		// Add the objects to WidgetView
		wv.add(carID);
		wv.add(carJTF);
		wv.add(carMile);
		wv.add(mileJTF);
		wv.add(carFuel);
		wv.add(fuelJTF);
		wv.add(jb);
		wv.add(fleetString);
		wv.add(fleetStringMPG);
		wv.add(bestMPG);
		wv.add(flAvg);
		wv.add(bestMile);

	}

	// Create class that manages button event. We are using elements of the
	// ActionListener interface
	// so we use "implements" rather than "extends".
	class ButtonEvent implements ActionListener {
		ButtonEvent() {

		}

		public void actionPerformed(ActionEvent e) {
			try {
				if (e.getActionCommand().equals("Make a new car")) {
					System.out.println("button has been clicked");
					// Get the text from the text fields and trim whitespace.
					idVal = carJTF.getText().trim();
					mileVal = Integer.parseInt(mileJTF.getText().trim());
					fuelVal = Integer.parseInt(fuelJTF.getText().trim());
					// Create new Car object passing the user input as parameters
					Car car = new Car(idVal, mileVal, fuelVal);
					// Add the car to the fleet class
					fl.add(car);

					fleetString.setText(fl.toString() + "\n");
					fleetStringMPG.setText((fl.getSortedByMPG()).toString());

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

}
