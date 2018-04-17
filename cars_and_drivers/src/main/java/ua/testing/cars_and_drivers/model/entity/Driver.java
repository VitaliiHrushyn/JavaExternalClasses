package ua.testing.cars_and_drivers.model.entity;

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
	        return "Driver{" +
	                System.identityHashCode(this)+
	                ", id=" + id +
	                ", name='" + name + '\'' +
	                ", phone=" + phone +
	                '}';
	    }
}
