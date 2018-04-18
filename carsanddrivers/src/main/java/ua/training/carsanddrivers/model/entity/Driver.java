package ua.training.carsanddrivers.model.entity;

import java.util.List;

public class Driver implements Entity {
	
	private int id;
	private String name;
	private String phone;
	
	private List<Car> cars;
	
	public Driver() {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	@Override
	    public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("Driver: ");
			sb.append(System.identityHashCode(this));
			sb.append(", id=" + id +
	                ", name='" + name + '\'' +
	                ", phone=" + phone +
	                ", cars: ");
			if (cars != null)
			for (Car car : cars) {
				sb.append(car.description() + ", ");
			}
			sb.append(".\n");
			return sb.toString();
	    }
	
	public String description() {
		return this.name + " (" + System.identityHashCode(this) + ")";
	}
}
