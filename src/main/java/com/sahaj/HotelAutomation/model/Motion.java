package com.sahaj.HotelAutomation.model;

public class Motion {
	private int floorNumber;

	private int subCorridorNumber;

	public Motion(int floorNumber, int subCorridorNumber) {
		this.floorNumber = floorNumber;
		this.subCorridorNumber = subCorridorNumber;
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public int getSubCorridorNumber() {
		return subCorridorNumber;
	}
}
