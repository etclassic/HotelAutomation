package com.sahaj.HotelAutomation.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sahaj.HotelAutomation.util.ElectricityConstants;

public abstract class Corridor {

	public List<LightBulb> getLightBulbs() {
		return lightBulbs;
	}

	public List<AirConditioner> getAirConditioners() {
		return airConditioners;
	}

	private List<LightBulb> lightBulbs;

	private List<AirConditioner> airConditioners;

	public Corridor(CorridorType type) {
		lightBulbs = new ArrayList<>();
		lightBulbs.add(new LightBulb(lightBulbs.size(), type == CorridorType.MAIN,
				ElectricityConstants.LIGHTBULB_POWER_RATING));
		airConditioners = new ArrayList<>();
		airConditioners.add(new AirConditioner(airConditioners.size(), true,
				ElectricityConstants.AIRCONDITIONER_POWER_RATING));
		setType(type);
	}

	public void addLightBulbs(LightBulb... lightBulbs) {
		this.lightBulbs.addAll(Arrays.asList(lightBulbs));
	}

	public void addAirConditioners(AirConditioner... airConditioners) {
		this.airConditioners.addAll(Arrays.asList(airConditioners));
	}

	public abstract CorridorType getType();

	public abstract void setType(CorridorType type);

	static enum CorridorType {
		MAIN, SUB
	}
}
