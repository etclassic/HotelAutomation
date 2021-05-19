package com.sahaj.HotelAutomation.input;

import java.util.Scanner;

public class ConsoleBasedInputReader implements HotelAutomationInputReader {
	private static final Scanner SCANNER = new Scanner(System.in);

	public void exit() {
		System.out.println("Thankyou for using Hotel Automation");
		SCANNER.close();
	}

	private static void throwExceptionForInvalidValue() {
		while (!SCANNER.hasNextInt()) {
			System.err.println("Invalid Value");
			SCANNER.nextLine();
		}
	}

	@Override
	public int getFloorCount() {
		System.out.println("Number of floors: ");
		throwExceptionForInvalidValue();
		int floorCount = Integer.parseInt(SCANNER.nextLine());
		return floorCount;
	}

	@Override
	public int getSubCorridorsCount() {
		System.out.println("s per floor: ");
		throwExceptionForInvalidValue();
		int subCorridorCount = Integer.parseInt(SCANNER.nextLine());
		return subCorridorCount;
	}

	@Override
	public int getMainCorridorsCount() {
		System.out.println("Main Corridors per floor: ");
		throwExceptionForInvalidValue();
		int mainCorridorCount = Integer.parseInt(SCANNER.nextLine());
		return mainCorridorCount;
	}

	@Override
	public int getFloorNumber() {
		System.out.println("Enter the Floor Number:");
		throwExceptionForInvalidValue();
		int floorNumber = Integer.parseInt(SCANNER.nextLine());
		return floorNumber;
	}

	@Override
	public int getSubcorridorNumber() {
		System.out.println("Enter  Number:");
		throwExceptionForInvalidValue();
		int subCorridorNumber = Integer.parseInt(SCANNER.nextLine());
		return subCorridorNumber;
	}

	@Override
	public void displayOptionsMenu() {
		System.out.println("Input Options:");
		System.out.println("1. Movement Detected");
		System.out.println("2. No Movement Detected");
		System.out.println("3. Exit");
	}

	@Override
	public int getInputChoice() {
		throwExceptionForInvalidValue();
		int choice = Integer.parseInt(SCANNER.nextLine());
		return choice;
	}

}
