package ua.training.carsanddrivers.model.services;

import ua.training.carsanddrivers.model.dao.DAOFactory;

public class DeleteCarService {
	
	public void deleteCar(int id) {
		DAOFactory.getInstance().createCarDAO().delete(id);
	}

}
