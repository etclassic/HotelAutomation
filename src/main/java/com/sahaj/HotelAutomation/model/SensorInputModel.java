package com.sahaj.HotelAutomation.model;

public class SensorInputModel {
	private int floorNumber;

	private int subCorridorNumber;

	private boolean isMotionDetected;

	public SensorInputModel(int floorNumber, int subCorridorNumber, boolean lightBulbToTurnOn) {
		this.floorNumber = floorNumber;
		this.subCorridorNumber = subCorridorNumber;
		this.isMotionDetected = lightBulbToTurnOn;
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public int getSubCorridorNumber() {
		return subCorridorNumber;
	}

	public boolean isMotionDeteted() {
		return isMotionDetected;
	}

}
