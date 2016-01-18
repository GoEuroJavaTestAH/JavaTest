package com.goeuro.java.model;

/**
 * GeoPosition JavaBean
 * 
 * @author ah
 *
 */
public class GeoPosition {
	private float latitude;
	private float longitude;

	/**
	 * Constructor
	 * 
	 * @param latitude
	 * @param longitude
	 */
	public GeoPosition(float latitude, float longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return String.format("GeoPosition: [Long: %f, Lat: %f]", getLongitude(), getLatitude());
	}
}
