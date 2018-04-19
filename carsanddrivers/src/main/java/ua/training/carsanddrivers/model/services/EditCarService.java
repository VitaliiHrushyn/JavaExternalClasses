package ua.training.carsanddrivers.model.services;

import ua.training.carsanddrivers.model.dao.DAOFactory;
import ua.training.carsanddrivers.model.dao.GenericDAO;

import ua.training.carsanddrivers.model.entity.Car;

public class EditCarService {
	
	public void edit(int id, String name, String number) {
		
		try (GenericDAO<Car> carDAO = DAOFactory.getInstance().createCarDAO()) {
			Car car = carDAO.getById(id);
			car.setName(name);
			car.setNumber(number);		
			carDAO.update(car);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
