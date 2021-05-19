package com.sahaj.HotelAutomation.model;

import java.util.List;

public class Floor {
	private int floorNumber;

	public int getFloorNumber() {
		return floorNumber;
	}

	private List<MainCorridor> mainCorridors;

	private List<SubCorridor> subCorridors;

	public Floor(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public List<MainCorridor> getMainCorridors() {
		return mainCorridors;
	}

	public void setMainCorridors(List<MainCorridor> mainCorridors) {
		this.mainCorridors = mainCorridors;
	}

	public List<SubCorridor> getSubCorridors() {
		return subCorridors;
	}

	public void setSubCorridors(List<SubCorridor> subCorridors) {
		this.subCorridors = subCorridors;
	}

	@Override
	public String toString() {
		return "Floor " + (floorNumber + 1);
	}
}
