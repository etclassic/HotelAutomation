package com.sahaj.HotelAutomation.util;

import com.sahaj.HotelAutomation.model.Floor;
import com.sahaj.HotelAutomation.model.Hotel;

import junit.framework.TestCase;

public class ElectricityConsumptionCriteriaTest extends TestCase {
	private ElectricityConsumptionCriteria electricityConsumptionCriteria;

	public void setUp() throws Exception {
		electricityConsumptionCriteria = new ElectricityConsumptionCriteria();
	}

	public void tearDown() throws Exception {
	}

	public void testCriteriaMetFor() {
		Hotel hotel = new Hotel.HotelBuilder("New", 3, 1, 2).build();
		Floor floor = hotel.getFloors().get(0);
		assertTrue( electricityConsumptionCriteria.criteriaMetFor(floor));
		floor.getSubCorridors().get(0).getAirConditioners().get(0).setSwitchedOn(true);
		floor.getSubCorridors().get(0).getLightBulbs().get(0).setSwitchedOn(true);
		electricityConsumptionCriteria.criteriaMetFor(floor);
		assertFalse( electricityConsumptionCriteria.criteriaMetFor(floor));
	}

}
