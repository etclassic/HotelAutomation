package com.sahaj.HotelAutomation.controller;

import com.sahaj.HotelAutomation.model.Hotel;
import com.sahaj.HotelAutomation.model.Motion;

import junit.framework.TestCase;

public class ElectricityControllerTest extends TestCase {
	private ElectricityController electricityController;

	private Hotel hotel;

	public void setUp() throws Exception {
		hotel = new Hotel.HotelBuilder("Hotel 1", 2, 2, 2).build();
		electricityController = new ElectricityController(hotel);
	}
	
	public void tearDown() throws Exception {
	}

	public void testElectricityController() {
		assertEquals(hotel, electricityController.getHotel());
	}

	public void testToggleSubCorridorsLights() {
		electricityController.toggleSubCorridorsLights(new Motion(1, 2), true);
		assertTrue(hotel.getFloors().get(0)
				.getSubCorridors().get(1).getLightBulbs().get(0).isSwitchedOn());
		electricityController.toggleSubCorridorsLights(new Motion(1, 2), true);
		assertTrue(hotel.getFloors().get(0)
				.getSubCorridors().get(1).getLightBulbs().get(0).isSwitchedOn());
		electricityController.toggleSubCorridorsLights(new Motion(1, 2), false);
		assertFalse(hotel.getFloors().get(0)
				.getSubCorridors().get(1).getLightBulbs().get(0).isSwitchedOn());
		electricityController.toggleSubCorridorsLights(new Motion(1, 2), false);
		assertFalse(hotel.getFloors().get(0)
				.getSubCorridors().get(1).getLightBulbs().get(0).isSwitchedOn());

	}
}
