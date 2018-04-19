package ua.training.carsanddrivers.model.services;

import java.util.List;

import ua.training.carsanddrivers.model.dao.DAOFactory;
import ua.training.carsanddrivers.model.dao.GenericDAO;
import ua.training.carsanddrivers.model.entity.Driver;

public class ShowDriversService {
	
	public List<Driver> getDrivers() {
		try(GenericDAO<Driver> driverDAO = DAOFactory.getInstance().createDriverDAO()) {
			return driverDAO.getAll(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}
