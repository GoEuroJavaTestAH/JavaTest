package com.goeuro.java.JavaTest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.goeuro.java.model.Location;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * The main Application class.
 * 
 * @author ah
 *
 */
public class App {
	private static final String CSV_FILE_EXT = ".csv";

	private final static Logger LOGGER = Logger.getLogger(App.class.getName());

	public static void main(String[] args) {
		LOGGER.setLevel(Level.SEVERE);
		LOGGER.info("Application has been called...");
		if (args.length != 1) {
			System.err.print("Wrong argument! Please enter one parameter only.");
			LOGGER.severe(String.format("Arguments #: %d", args.length));
			System.exit(0);
		}

		// get city name from the arguments
		String cityName = args[0];

		LOGGER.info(String.format("Cityname ; %s, trying to load locations from API...", cityName));

		// Get locations json from GoEuro API
		APIClient apiClient = new APIClient();
		String locationsJson = "";
		try {
			locationsJson = apiClient.GetLocations(cityName);

		} catch (Exception e) {
			System.err.print("Error while trying to read locations from API.");
			System.exit(0);
		}

		// Convert locations json string to List
		Gson gson = new Gson();
		Type listType = new TypeToken<ArrayList<Location>>() {
		}.getType();
		List<Location> locations = gson.fromJson(locationsJson, listType);

		LOGGER.info(String.format("Parsed %d locations... Trying to write to file...", locations.size()));

		LOGGER.info("Returned locations string... Trying to parse...");

		// Write relevant fields to CSV file
		try {
			LocationsFileWriter.WriteCsvFile(cityName + CSV_FILE_EXT, locations);
		} catch (Exception e) {
			System.err.print("Error while trying to write CSV file to disk.");
			System.exit(0);
		}
		System.out.println("CSV file was created successfully!");
		LOGGER.info(String.format("Locations were written to file: %s%s. DONE!", cityName, CSV_FILE_EXT));
	}
}
