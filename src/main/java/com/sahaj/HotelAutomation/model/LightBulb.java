package com.sahaj.HotelAutomation.model;

import com.sahaj.HotelAutomation.util.ElectricityConstants;

public class LightBulb {
	private int powerConsumption;

	private boolean switchedOn;

	private int lightNumber;

	public LightBulb(int lightNumber, boolean switchedOn, int powerConsumption) {
		this.lightNumber = lightNumber;
		this.switchedOn = switchedOn;
		this.powerConsumption = powerConsumption;
	}

	public boolean isSwitchedOn() {
		return switchedOn;
	}

	public void setSwitchedOn(boolean switchedOn) {
		this.switchedOn = switchedOn;
	}

	public int getPowerConsumption() {
		return powerConsumption;
	}

	public void setPowerConsumption(int powerConsumption) {
		this.powerConsumption = powerConsumption;
	}

	public int getLightNumber() {
		return lightNumber;
	}

	@Override
	public String toString() {
		return ElectricityConstants.DOUBLE_SPACES + ElectricityConstants.DOUBLE_SPACES + "Light " + (lightNumber + 1) + " : "
				+ (switchedOn ? "ON" : "OFF");
	}

}
