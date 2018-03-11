package ua.testing.regex.model;

public class Address {
	
	private String ZIPcode;
	private String locality;
	private String street;
	private String buildingNumber;
	private String appartmentNumber;
	
	public Address() {
		super();
	}

	public String getZIPcode() {
		return ZIPcode;
	}

	public void setZIPcode(String zIPcode) {
		ZIPcode = zIPcode;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public String getAppartmentNumber() {
		return appartmentNumber;
	}

	public void setAppartmentNumber(String appartmentNumber) {
		this.appartmentNumber = appartmentNumber;
	}

	@Override
	public String toString() {
		return "Address: " +
				"\n\t ZIPcode: " + ZIPcode + 
				"\n\t locality: " + locality + 
				"\n\t street: " + street + 
				"\n\t buildingNumber: " + buildingNumber + 
				"\n\t appartmentNumber=" + appartmentNumber + ".";
	}
	
}
