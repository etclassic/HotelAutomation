package com.sahaj.HotelAutomation.processor;

import com.sahaj.HotelAutomation.controller.ElectricityController;
import com.sahaj.HotelAutomation.input.HotelAutomationInputReader;
import com.sahaj.HotelAutomation.util.ElectricityConstants;
import com.sahaj.HotelAutomation.model.Hotel;
import com.sahaj.HotelAutomation.model.Motion;
import com.sahaj.HotelAutomation.model.SensorInputModel;

public class HotelAutomationProcessor {

	private HotelAutomationInputReader hotelManagementInputReader;

	public HotelAutomationProcessor(HotelAutomationInputReader hotelManagementInputReader) {
		this.hotelManagementInputReader = hotelManagementInputReader;
	}

	/**
	 * Initiates the hotel. Reads sensor inputs. Sends the input to control
	 * unit.
	 * 
	 */
	public void process() {
		System.out.println("Welcome to Hotel Automation!");

		int floorCount = hotelManagementInputReader.getFloorCount();
		int mainCorridorCount = hotelManagementInputReader.getMainCorridorsCount();
		int subCorridorCount = hotelManagementInputReader.getSubCorridorsCount();

		Hotel hotel = new Hotel.HotelBuilder("New", floorCount, mainCorridorCount, subCorridorCount).build();

		System.out.println(hotel);
		ElectricityController controller = new ElectricityController(hotel);
		while (true) {
			try {
				SensorInputModel sensorInput = parseSensorInputs();
				if (sensorInput != null) {
					controller.toggleSubCorridorsLights(
							new Motion(sensorInput.getFloorNumber(), sensorInput.getSubCorridorNumber()),
							sensorInput.isMotionDeteted());
					System.out.println(hotel);
				}

			} catch (IllegalArgumentException exception) {
				System.err.println(exception.getMessage());
			}
		}

	}

	private SensorInputModel parseSensorInputs() {
		hotelManagementInputReader.displayOptionsMenu();
		int inputChoice = hotelManagementInputReader.getInputChoice();
		int floorNumber = 0;
		int subCorridorNumber = 0;
		if (inputChoice == ElectricityConstants.INPUT_EXIT_OPTION) {
			hotelManagementInputReader.exit();
			System.exit(0);
		} else if (inputChoice == ElectricityConstants.INPUT_MOVEMENT_OPTION
				|| inputChoice == ElectricityConstants.INPUT_NO_MOVEMENT_OPTION) {
			floorNumber = hotelManagementInputReader.getFloorNumber();
			subCorridorNumber = hotelManagementInputReader.getSubcorridorNumber();
		} else {
			System.out.println("Invalid Option");
			return null;
		}
		return new SensorInputModel(floorNumber, subCorridorNumber,
				inputChoice == ElectricityConstants.INPUT_MOVEMENT_OPTION);
	}
}
