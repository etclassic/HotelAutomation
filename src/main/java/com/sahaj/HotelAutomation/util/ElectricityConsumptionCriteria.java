package com.sahaj.HotelAutomation.util;

import java.util.List;

import com.sahaj.HotelAutomation.model.AirConditioner;
import com.sahaj.HotelAutomation.model.Floor;
import com.sahaj.HotelAutomation.model.LightBulb;
import com.sahaj.HotelAutomation.model.MainCorridor;
import com.sahaj.HotelAutomation.model.SubCorridor;

public class ElectricityConsumptionCriteria {

	public boolean criteriaMetFor(Floor floor) {
		return electricityConsumptionForFloor(floor) <= getMaxElectricityAllowedForFloor(floor);
	}

	/**
	 * Calculates the Maximum Electricity a Floor can use at any given point of
	 * time.
	 */
	private int getMaxElectricityAllowedForFloor(Floor floor) {
		List<MainCorridor> mainCorridors = floor.getMainCorridors();
		List<SubCorridor> subCorridors = floor.getSubCorridors();
		return (mainCorridors.size() * 15) + subCorridors.size() * 10;
	}

	/**
	 * Calculates the Electrical power consumed by the equipments found on the
	 * given Floor.
	 */
	private int electricityConsumptionForFloor(Floor floor) {
		List<MainCorridor> mainCorridors = floor.getMainCorridors();
		List<SubCorridor> subCorridors = floor.getSubCorridors();

		int sumOfPowersOfLightBulbsinMainCorridors = 0;
		int sumOfPowersOfAirConditionersinMainCorridors = 0;
		int sumOfPowersOfLightBulbsinSubCorridors = 0;
		int sumOfPowersOfAirConditionersinSubCorridors = 0;

		for (MainCorridor mainCorridor : mainCorridors) {

			for (LightBulb lightBulb : mainCorridor.getLightBulbs()) {
				if (lightBulb.isSwitchedOn()) {
					sumOfPowersOfLightBulbsinMainCorridors += lightBulb.getPowerConsumption();
				}
			}

			for (AirConditioner airConditioner : mainCorridor.getAirConditioners()) {
				if (airConditioner.isSwitchedOn()) {
					sumOfPowersOfAirConditionersinMainCorridors += airConditioner.getPowerConsumption();
				}
			}
		}

		for (SubCorridor subCorridor : subCorridors) {

			for (LightBulb lightBulb : subCorridor.getLightBulbs()) {
				if (lightBulb.isSwitchedOn()) {
					sumOfPowersOfLightBulbsinSubCorridors += lightBulb.getPowerConsumption();
				}
			}

			for (AirConditioner airConditioner : subCorridor.getAirConditioners()) {
				if (airConditioner.isSwitchedOn()) {
					sumOfPowersOfAirConditionersinSubCorridors += airConditioner.getPowerConsumption();
				}
			}
		}

		return sumOfPowersOfLightBulbsinMainCorridors + sumOfPowersOfLightBulbsinSubCorridors
				+ sumOfPowersOfAirConditionersinMainCorridors + sumOfPowersOfAirConditionersinSubCorridors;
	}
}
