package com.bytecode.bo;

public class BO_6 {
    
	
	private String Name;
	private long mobileNumber;
	private String address;
	private int zipCode;
	private String nearestPoliceStationName;
	private String complainType;
	private String whereDidTheIncidentOccurs;
	private String additionalInformation;
	private String uniqueId;
	public String getName() {
		return Name;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public int getZipCode() {
		return zipCode;
	}
	public String getNearestPoliceStationName() {
		return nearestPoliceStationName;
	}
	public String getComplainType() {
		return complainType;
	}
	public String getWhereDidTheIncidentOccurs() {
		return whereDidTheIncidentOccurs;
	}
	public String getAdditionalInformation() {
		return additionalInformation;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public void setNearestPoliceStationName(String nearestPoliceStationName) {
		this.nearestPoliceStationName = nearestPoliceStationName;
	}
	public void setComplainType(String complainType) {
		this.complainType = complainType;
	}
	public void setWhereDidTheIncidentOccurs(String whereDidTheIncidentOccurs) {
		this.whereDidTheIncidentOccurs = whereDidTheIncidentOccurs;
	}
	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
}
