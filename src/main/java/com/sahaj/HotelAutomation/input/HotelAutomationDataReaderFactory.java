package com.sahaj.HotelAutomation.input;

public class HotelAutomationDataReaderFactory {
	private static final HotelAutomationDataReaderFactory hotelManagementInputReaderFactory = new HotelAutomationDataReaderFactory();

	public static HotelAutomationDataReaderFactory getInstance() {
		return hotelManagementInputReaderFactory;
	}

	public HotelAutomationInputReader getReader() {
		return new ConsoleBasedInputReader();
	}}
