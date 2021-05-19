package com.sahaj.HotelAutomation.model;

import com.sahaj.HotelAutomation.util.ElectricityConstants;

public class MainCorridor extends Corridor {
	private CorridorType type;

	private boolean nightTime;

	private int corridorNumber;

	public MainCorridor(int corridorNumber) {
		super(CorridorType.MAIN);
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

	public boolean isNightTime() {
		return nightTime;
	}

	public void setNightTime(boolean nightTime) {
		this.nightTime = nightTime;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(ElectricityConstants.DOUBLE_SPACES + "Main corridor " + (corridorNumber + 1));
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
