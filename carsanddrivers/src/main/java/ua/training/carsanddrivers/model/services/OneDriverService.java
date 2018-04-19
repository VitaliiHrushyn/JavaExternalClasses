package ua.training.carsanddrivers.model.services;

import ua.training.carsanddrivers.model.dao.DAOFactory;
import ua.training.carsanddrivers.model.dao.GenericDAO;
import ua.training.carsanddrivers.model.entity.Driver;

public class OneDriverService {
	
	public Driver getDriverById(int id) {
		try(GenericDAO<Driver> driverDAO = DAOFactory.getInstance().createDriverDAO()) {
			return driverDAO.getById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}
