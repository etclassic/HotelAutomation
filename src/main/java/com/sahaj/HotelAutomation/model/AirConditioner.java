package com.sahaj.HotelAutomation.model;

import com.sahaj.HotelAutomation.util.ElectricityConstants;

public class AirConditioner {

	private boolean switchedOn;

	private int acNumber;

	private int powerConsumption;

	public int getLightNumber() {
		return acNumber;
	}

	public AirConditioner(int acNumber, boolean switchedOn, int powerConsumption) {
		this.acNumber = acNumber;
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

	@Override
	public String toString() {
		return ElectricityConstants.DOUBLE_SPACES + ElectricityConstants.DOUBLE_SPACES + "AC : "
				+ (switchedOn ? "ON" : "OFF");
	}
}
