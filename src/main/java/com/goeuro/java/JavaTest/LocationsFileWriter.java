package com.goeuro.java.JavaTest;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import com.goeuro.java.model.Location;

public class LocationsFileWriter {
		
		private final static Logger LOGGER = Logger.getLogger(LocationsFileWriter.class.getName()); 

		// New line used in CSV file
		private static final String NEW_LINE_SEPARATOR = "\n";
		
		// CSV file header
		private static final Object [] FILE_HEADER = {"_id","name","type","latitude","latitude"};

		/**
		 * Write locations to CSV file
		 * @param fileName the file name of the csv file (inlcuding the extension)
		 * @param locations a list of the locations to be written to file
		 * @throws Exception an exception is thrown in case of error
		 */
		public static void WriteCsvFile(String fileName, List<Location> locations) throws Exception {
			LOGGER.setLevel(Level.SEVERE);
			
			FileWriter fileWriter = null;
			CSVPrinter csvFilePrinter = null;

			LOGGER.info(String.format("Started to write %d locations to file: %s .", locations.size(), fileName));
			
			CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
			
			try {
				// Initialize FileWriter object
				fileWriter = new FileWriter(fileName);

				// Initialize CSVPrinter object
				csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);

				// Create CSV file header
	            csvFilePrinter.printRecord(FILE_HEADER);

				//Write a new location object list to the CSV file
				for (Location location : locations) {
					List<Comparable> locRecord = new ArrayList<Comparable>();
					locRecord.add(String.valueOf(location.getId()));
					locRecord.add(location.getFullName());
					locRecord.add(location.getType());
					locRecord.add(location.getGeoPosition().getLatitude());
					locRecord.add(location.getGeoPosition().getLongitude());
	
					csvFilePrinter.printRecord(locRecord);
				}
			} catch (Exception e) {
				LOGGER.severe(String.format("Error while trying to write CSV file! message: %s", 
						e.getMessage()));
				throw e;
			} finally {
				try {
					fileWriter.flush();
					fileWriter.close();
				} catch (IOException e) {
					LOGGER.severe(String.format("Error while trying to flush CSV file! message: %s", 
							e.getMessage()));
					
	                throw e;
				}
				
			}
		}
	}