package com.sahaj.HotelAutomation;

import com.sahaj.HotelAutomation.input.HotelAutomationDataReaderFactory;
import com.sahaj.HotelAutomation.input.HotelAutomationInputReader;
import com.sahaj.HotelAutomation.processor.HotelAutomationProcessor;

/**
 * Hotel Automation program!
 *
 */
public class App {
	public static void main(String[] args) {

		HotelAutomationInputReader hotelManagementInputReader = HotelAutomationDataReaderFactory.getInstance()
				.getReader();
		new HotelAutomationProcessor(hotelManagementInputReader).process();

	}
}
