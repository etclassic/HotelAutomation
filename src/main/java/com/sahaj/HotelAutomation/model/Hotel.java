package com.sahaj.HotelAutomation.model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
	private List<Floor> floors;

	private String name;

	public Hotel(String name, List<Floor> floors) {
		this.name = name;
		this.floors = floors;
	}

	public List<Floor> getFloors() {
		return floors;
	}

	public String getName() {
		return name;
	}

	public Floor getFloor(int floorNumber){
		for (Floor floor : this.getFloors()) {
			if (floor.getFloorNumber() == (floorNumber - 1))
				return floor;
		}
		throw new RuntimeException("No Matching Floor found");
	}

	/**
	 * Prints the Hotel along with the main corridors and s on each
	 * floor
	 *
	 */
	public String toString() {
		final StringBuilder stringBuilder = new StringBuilder();
		for (Floor floor : getFloors()) {
			stringBuilder.append(floor).append(System.lineSeparator());
			for (MainCorridor mainCorridor : floor.getMainCorridors()) {
				stringBuilder.append(mainCorridor.toString()).append(System.lineSeparator());
			}
			for (SubCorridor subCorridor : floor.getSubCorridors()) {
				stringBuilder.append(subCorridor.toString()).append(System.lineSeparator());
			}
		}
		return stringBuilder.toString();
	}

	public static class HotelBuilder {

		private String name;
		private List<Floor> floors = new ArrayList<Floor>();

		public HotelBuilder(String name, int noOfFloors, int noOfCorridors
				, int noOfSubcorridors) {
			this.name = name;
			this.addFloors(noOfFloors)
					.addMainCorridors(noOfCorridors)
					.addSubCorridors(noOfSubcorridors);
		}

		/**
		 * Adds as many floors to the count as requested.
		 *
		 * @param floorCount
		 * @return
		 */
		public HotelBuilder addFloors(int floorCount) {
			for (int counter = 0; counter < floorCount; counter++) {
				Floor floor = new Floor(counter);
				floor.setMainCorridors(new ArrayList<MainCorridor>());
				floor.setSubCorridors(new ArrayList<SubCorridor>());
				floors.add(floor);
			}
			return this;
		}

		/**
		 * Adds as many MainCorridors to each floor as requested.
		 *
		 * @param mainCorridorCount
		 * @return
		 */
		public HotelBuilder addMainCorridors(int mainCorridorCount) {
			int floorCount = floors.size();
			for (int floorCounter = 0; floorCounter < floorCount; floorCounter++) {
				for (int corridorCounter = 0; corridorCounter < mainCorridorCount; corridorCounter++) {
					MainCorridor mainCorridor = new MainCorridor(corridorCounter);
					floors.get(floorCounter).getMainCorridors()
							.add(mainCorridor);
				}
			}
			return this;
		}

		/**
		 * Adds as many SubCorridors to each floor as requested.
		 *
		 * @param subCorridorCount
		 * @return
		 */
		public HotelBuilder addSubCorridors(int subCorridorCount) {
			int floorCount = floors.size();
			for (int floorCounter = 0; floorCounter < floorCount; floorCounter++) {
				for (int corridorCounter = 0; corridorCounter < subCorridorCount; corridorCounter++) {
					SubCorridor subCorridor = new SubCorridor(corridorCounter);
					floors.get(floorCounter).getSubCorridors()
							.add(subCorridor);
				}
			}
			return this;
		}

		/**
		 * Returns the hotel instance at this given instant.
		 *
		 * @return
		 */
		public Hotel build() {
			return new Hotel(name, floors);
		}

	}

}
