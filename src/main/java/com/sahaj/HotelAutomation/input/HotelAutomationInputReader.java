package com.sahaj.HotelAutomation.input;

public interface HotelAutomationInputReader {
	int getFloorCount();
	int getSubCorridorsCount();
	int getMainCorridorsCount();
	int getFloorNumber();
	int getSubcorridorNumber();
	void displayOptionsMenu();
	void exit();
	int getInputChoice();
}
