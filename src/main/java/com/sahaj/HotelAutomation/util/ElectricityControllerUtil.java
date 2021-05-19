package com.sahaj.HotelAutomation.util;

import com.sahaj.HotelAutomation.model.Floor;
import com.sahaj.HotelAutomation.model.Hotel;
import com.sahaj.HotelAutomation.model.Motion;
import com.sahaj.HotelAutomation.model.SubCorridor;

public class ElectricityControllerUtil {

	public void switchACOnAtSubCorridor(SubCorridor subCorridor) {
		subCorridor.getAirConditioners().get(0).setSwitchedOn(true);
	}

	public void switchACOffAtSubCorridor(SubCorridor subCorridor) {
		subCorridor.getAirConditioners().get(0).setSwitchedOn(false);
	}

	public boolean isLightBulbSwitchedOnAtSubCorridor(SubCorridor subCorridor) {
		return subCorridor.getLightBulbs().get(0).isSwitchedOn();
	}

	public Floor findMatchingFloor(Hotel hotel, final Motion motion) {
		for (Floor floor : hotel.getFloors()) {
			if (floor.getFloorNumber() == (motion.getFloorNumber() - 1))
				return floor;
		}

		return null;
	}

	public SubCorridor findMatchingSubCorridor(final Motion motion, Floor matchingFloor) {
		for (SubCorridor subCorridor : matchingFloor.getSubCorridors()) {
			if (subCorridor.getCorridorNumber() == (motion.getSubCorridorNumber() - 1)) {
				return subCorridor;
			}
		}
		return null;
	}

	public SubCorridor findSomeOtherSubCorridor(final Motion motion, Floor matchingFloor,
			SubCorridor matchingSubCorridor) {
		for (SubCorridor subCorridor : matchingFloor.getSubCorridors()) {
			if (subCorridor.getCorridorNumber() != (motion.getSubCorridorNumber() - 1)) {
				return subCorridor;
			}
		}
		return matchingSubCorridor;
	}
}
