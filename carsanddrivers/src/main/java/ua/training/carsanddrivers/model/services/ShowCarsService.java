package ua.training.carsanddrivers.model.services;

import java.util.List;

import ua.training.carsanddrivers.model.dao.DAOFactory;
import ua.training.carsanddrivers.model.entity.Car;

public class ShowCarsService {
	
	public List<Car> getCars() {
		return DAOFactory.getInstance().createCarDAO().getAll(true);
	}

}
