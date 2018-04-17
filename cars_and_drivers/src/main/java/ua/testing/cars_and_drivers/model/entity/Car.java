package ua.testing.cars_and_drivers.model.entity;

import java.util.List;

public class Car implements Entity {
	
	private int id;
	private String name;
	private String number;
	
	private List<Driver> drivers;

	public Car() {
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



	public String getNumber() {
		return number;
	}



	public void setNumber(String number) {
		this.number = number;
	}



	public List<Driver> getDrivers() {
		return drivers;
	}



	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}



	@Override
    public String toString() {
        return "\nCar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", drivers=" + drivers +
                '}';
    }

}
