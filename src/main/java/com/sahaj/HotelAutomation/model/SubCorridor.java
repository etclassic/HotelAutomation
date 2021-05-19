package com.sahaj.HotelAutomation.model;

import com.sahaj.HotelAutomation.util.ElectricityConstants;

public class SubCorridor extends Corridor {
	private CorridorType type;

	private boolean motionDetected;

	private int corridorNumber;

	public SubCorridor(int corridorNumber) {
		super(CorridorType.SUB);
		this.corridorNumber = corridorNumber;
	}

	public int getCorridorNumber() {
		return corridorNumber;
	}

	@Override
	public CorridorType getType() {
		return type;
	}

	@Override
	public void setType(CorridorType type) {
		this.type = type;
	}

	public boolean isMotionDetected() {
		return motionDetected;
	}

	public void setMotionDetected(boolean motionDetected) {
		this.motionDetected = motionDetected;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(ElectricityConstants.DOUBLE_SPACES + "Sub corridor " + (corridorNumber + 1));
		sb.append(System.lineSeparator());
		for (LightBulb lightBulb : getLightBulbs()) {
			sb.append(lightBulb).append(System.lineSeparator());
		}
		for (AirConditioner airConditioner : getAirConditioners()) {
			sb.append(airConditioner).append(System.lineSeparator());
		}
		return sb.toString();
	}
}
