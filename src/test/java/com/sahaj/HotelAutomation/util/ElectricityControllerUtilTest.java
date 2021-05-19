package com.sahaj.HotelAutomation.util;

import com.sahaj.HotelAutomation.model.Floor;
import com.sahaj.HotelAutomation.model.Hotel;
import com.sahaj.HotelAutomation.model.Motion;
import com.sahaj.HotelAutomation.model.SubCorridor;

import junit.framework.TestCase;

public class ElectricityControllerUtilTest extends TestCase {
	private ElectricityControllerUtil electricityControllerUtil;

	private Hotel hotel;

	public void setUp() throws Exception {
		electricityControllerUtil = new ElectricityControllerUtil();
		hotel = new Hotel.HotelBuilder("New", 2, 2, 2).build();
	}

	public void tearDown() throws Exception {
	}

	public void testSwitchACOnAtSubCorridor() {
		SubCorridor subCorridor = hotel.getFloors().get(0).getSubCorridors().get(0);
		electricityControllerUtil.switchACOnAtSubCorridor(subCorridor);
		assertTrue(subCorridor.getAirConditioners().get(0).isSwitchedOn());
	}

	public void testSwitchACOffAtSubCorridor() {
		SubCorridor subCorridor = hotel.getFloors().get(0).getSubCorridors().get(0);
		electricityControllerUtil.switchACOffAtSubCorridor(subCorridor);
		assertFalse(subCorridor.getAirConditioners().get(0).isSwitchedOn());
	}

	public void testIsLightBulbSwitchedOnAtSubCorridor() {
		SubCorridor subCorridor = hotel.getFloors().get(0).getSubCorridors().get(0);
		assertFalse(electricityControllerUtil.isLightBulbSwitchedOnAtSubCorridor(subCorridor));
		subCorridor.getLightBulbs().get(0).setSwitchedOn(true);
		assertTrue(electricityControllerUtil.isLightBulbSwitchedOnAtSubCorridor(subCorridor));
	}

	public void testFindMatchingFloor() {
		Motion motion = new Motion(1, 1);
		Floor matchingFloor = electricityControllerUtil.findMatchingFloor(hotel, motion);
		assertTrue(0 == matchingFloor.getFloorNumber());

		// Invalid Motion
		motion = new Motion(-1, 1);
		matchingFloor = electricityControllerUtil.findMatchingFloor(hotel, motion);
		assertNull(matchingFloor);
	}

	public void testFindMatchingSubCorridor() {
		Motion motion = new Motion(1, 2);
		Floor matchingFloor = electricityControllerUtil.findMatchingFloor(hotel, motion);
		SubCorridor matchingSubCorridor = electricityControllerUtil.findMatchingSubCorridor(motion, matchingFloor);
		assertTrue(1 == matchingSubCorridor.getCorridorNumber());
	}

	public void testFindSomeOtherSubCorridor() {
		Motion motion = new Motion(1, 2);
		Floor matchingFloor = electricityControllerUtil.findMatchingFloor(hotel, motion);
		SubCorridor matchingSubCorridor = electricityControllerUtil.findMatchingSubCorridor(motion, matchingFloor);
		SubCorridor someOtherSubCorridor = electricityControllerUtil.findSomeOtherSubCorridor(motion, matchingFloor,
				matchingSubCorridor);
		assertFalse(1 == someOtherSubCorridor.getCorridorNumber());

		SubCorridor removedSubCorridor = hotel.getFloors().get(0).getSubCorridors().remove(0);
		someOtherSubCorridor = electricityControllerUtil.findSomeOtherSubCorridor(motion, matchingFloor,
				matchingSubCorridor);
		assertTrue(1 == someOtherSubCorridor.getCorridorNumber());
		hotel.getFloors().get(0).getSubCorridors().add(removedSubCorridor);
	}

}
