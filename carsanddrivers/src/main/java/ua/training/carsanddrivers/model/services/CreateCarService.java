package ua.training.carsanddrivers.model.services;

import ua.training.carsanddrivers.model.dao.DAOFactory;
import ua.training.carsanddrivers.model.dao.GenericDAO;

import ua.training.carsanddrivers.model.entity.Car;

public class CreateCarService {
	
	public void create(String name, String number) {
		
		try (GenericDAO<Car> carDAO = DAOFactory.getInstance().createCarDAO()) {
			Car car = new Car();		
			car.setName(name);
			car.setNumber(number);		
			carDAO.create(car);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
