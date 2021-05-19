package com.sahaj.HotelAutomation.controller;

import java.util.HashMap;
import java.util.Map;

import com.sahaj.HotelAutomation.model.AirConditioner;
import com.sahaj.HotelAutomation.model.Floor;
import com.sahaj.HotelAutomation.model.Hotel;
import com.sahaj.HotelAutomation.model.LightBulb;
import com.sahaj.HotelAutomation.model.Motion;
import com.sahaj.HotelAutomation.model.SubCorridor;
import com.sahaj.HotelAutomation.util.ElectricityConsumptionCriteria;
import com.sahaj.HotelAutomation.util.ElectricityControllerUtil;

public class ElectricityController {
	private Hotel hotel;
	private ElectricityControllerUtil electricityControllerUtil;

	/**
	 * Stores information on which SubCorridor's AC was turned on when some
	 * other Subcorridor's Light Bulb had to be switched ON to maintain the
	 * correct level of Electricity consumption.
	 * 
	 */
	private Map<SubCorridor, SubCorridor> subCorridorMap;

	public ElectricityController(Hotel hotel) {
		this.hotel = hotel;
		subCorridorMap = new HashMap<>();
		electricityControllerUtil = new ElectricityControllerUtil();
	}

	private boolean isElectricityConsumptionExceededForFloor(Floor floor) {
		ElectricityConsumptionCriteria electricityConsumptionCriteria = new ElectricityConsumptionCriteria();
		return !electricityConsumptionCriteria.criteriaMetFor(floor);
	}

	/**
	 * Toggles the Light On for the matching SubCorridor where the motion was
	 * detected. Toggles the Light Off where no movement was detected. Same time
	 * toggles the AC back on if no movement detected.
	 * 
	 * @param motion
	 * @param isMotionDetected
	 */
	public void toggleSubCorridorsLights(Motion motion, final boolean isMotionDetected) {
		Floor matchingFloor = electricityControllerUtil.findMatchingFloor(hotel, motion);
		SubCorridor matchingSubCorridor = electricityControllerUtil.findMatchingSubCorridor(motion, matchingFloor);
		if (electricityControllerUtil.isLightBulbSwitchedOnAtSubCorridor(matchingSubCorridor) == isMotionDetected) {
			return;
		}

		for (LightBulb lightBulb : matchingSubCorridor.getLightBulbs()) {
			lightBulb.setSwitchedOn(isMotionDetected);
		}

		if (!isMotionDetected) {
			// If motion is not detected switch the AC on
			for (AirConditioner airConditioner : matchingSubCorridor.getAirConditioners()) {
				airConditioner.setSwitchedOn(!isMotionDetected);
			}
			SubCorridor otherSubCorridor = subCorridorMap.get(matchingSubCorridor);
			if (otherSubCorridor != null)
				electricityControllerUtil.switchACOnAtSubCorridor(otherSubCorridor);
		}

		if (isElectricityConsumptionExceededForFloor(matchingFloor)) {
			SubCorridor someOtherSubCorridor = electricityControllerUtil.findSomeOtherSubCorridor(motion, matchingFloor,
					matchingSubCorridor);
			electricityControllerUtil.switchACOffAtSubCorridor(someOtherSubCorridor);
			subCorridorMap.put(matchingSubCorridor, someOtherSubCorridor);
		}
	}

	public Hotel getHotel() {
		return hotel;
	}

	public ElectricityControllerUtil getElectricityControllerUtil() {
		return electricityControllerUtil;
	}

	public Map<SubCorridor, SubCorridor> getSubCorridorCoordination() {
		return subCorridorMap;
	}
}
