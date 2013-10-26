package com.batch.springbatch.jobs.model;

public class BicingStation {

  private int id;
  private float lat;
  private float lon;
  private String street;
  private String streetNumber;
  
  public String toString() {
	 return this.id + " " + this.street;
  }
  
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public float getLat() {
	return lat;
}
public void setLat(float lat) {
	this.lat = lat;
}
public float getLon() {
	return lon;
}
public void setLon(float lon) {
	this.lon = lon;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getStreetNumber() {
	return streetNumber;
}
public void setStreetNumber(String streetNumber) {
	this.streetNumber = streetNumber;
}
  
  
  
	
}
