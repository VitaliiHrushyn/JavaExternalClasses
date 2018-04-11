package sqltask.model.entities;

public class Car {
	
	private int carId;
	private String model;
	private String manufacturer;
	
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
	
}
