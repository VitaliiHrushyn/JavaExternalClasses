package ua.testing.cars_and_drivers.model.entity;

@Deprecated
public class Shop {
	
	private int id;
	private String name;
	private String phoneNumber;	
	private Driver manufacturer;

	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Driver getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Driver manufacturer) {
		this.manufacturer = manufacturer;
	}

}
