package com.goeuro.java.model;

import javax.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Location Java Bean
 * 
 * @author ah
 *
 */
public class Location {
	@SerializedName("_id")
	private long id;
	private @Nullable Object key;
	private String name;
	private String fullName;

	@SerializedName("iata_airport_code")
	private @Nullable String iataAirportCode;
	private String type;
	private String country;

	@SerializedName("geo_position")
	private GeoPosition geoPosition;
	private long locationId;
	private boolean inEurope;
	private String countryCode;
	private boolean coreCountry;
	private @Nullable float distance;

	public Location(long id, Object key, String name, String fullName, String iataAirportCode, String type,
			String country, GeoPosition geoPosition, long locationId, boolean inEurope, String countryCode,
			boolean coreCountry) {
		super();
		this.id = id;
		this.key = key;
		this.name = name;
		this.fullName = fullName;
		this.iataAirportCode = iataAirportCode;
		this.type = type;
		this.country = country;
		this.geoPosition = geoPosition;
		this.locationId = locationId;
		this.inEurope = inEurope;
		this.countryCode = countryCode;
		this.coreCountry = coreCountry;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Object getKey() {
		return key;
	}

	public void setKey(Object key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	String getIataAirportCode() {
		return iataAirportCode;
	}

	void setIataAirportCode(String iataAirportCode) {
		this.iataAirportCode = iataAirportCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public GeoPosition getGeoPosition() {
		return geoPosition;
	}

	public void setGeoPosition(GeoPosition geoPosition) {
		this.geoPosition = geoPosition;
	}

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public boolean isInEurope() {
		return inEurope;
	}

	public void setInEurope(boolean inEurope) {
		this.inEurope = inEurope;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public boolean isCoreCountry() {
		return coreCountry;
	}

	public void setCoreCountry(boolean coreCountry) {
		this.coreCountry = coreCountry;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return String.format(
				"id: %d,\nname: %s,\nfullName: %s,\niata_airport_code: %s,\ntype: %s,\n"
						+ "country: %s,\nlocationId: %d,\ninEurope?: %b,\ncountryCode: %b,\ncoreCountry?: %b,\n"
						+ "distance: %f,\nGeo position: %s\n",
				id, getName(), getFullName(), getIataAirportCode(), getType(), getCountry(), getLocationId(),
				isInEurope(), getCountryCode(), isCoreCountry(), getDistance(), getGeoPosition());
	}

}
