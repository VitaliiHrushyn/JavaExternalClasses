package sqltask.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Car {
	
	private int carId;
	private String model;
	private String manufacturer;
	private List<Driver> drivers = new ArrayList<>();
	
	public Car() {
		super();
	}

	public int getIdcar() {
		return carId;
	}

	public void setIdcar(int carId) {
		this.carId = carId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public void addDriver(Driver driver) {
		drivers.add(driver);
	}
	
	public List<Driver> getDrivers() {
		return drivers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + carId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (carId != other.carId)
			return false;
		return true;
	}
	
	
	
}
