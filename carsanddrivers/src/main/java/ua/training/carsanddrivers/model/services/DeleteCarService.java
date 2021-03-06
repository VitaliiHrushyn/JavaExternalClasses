package ua.training.carsanddrivers.model.services;

import ua.training.carsanddrivers.model.dao.DAOFactory;
import ua.training.carsanddrivers.model.dao.GenericDAO;
import ua.training.carsanddrivers.model.entity.Car;

public class DeleteCarService {
	
	public void delete(int id) {
		try (GenericDAO<Car> carDAO = DAOFactory.getInstance().createCarDAO()) {
			carDAO.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
