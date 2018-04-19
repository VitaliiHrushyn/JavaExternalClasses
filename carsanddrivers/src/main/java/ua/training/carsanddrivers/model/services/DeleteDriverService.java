package ua.training.carsanddrivers.model.services;

import ua.training.carsanddrivers.model.dao.DAOFactory;
import ua.training.carsanddrivers.model.dao.GenericDAO;
import ua.training.carsanddrivers.model.entity.Driver;

public class DeleteDriverService {
	
	public void delete(int id) {
		try(GenericDAO<Driver> driverDAO = DAOFactory.getInstance().createDriverDAO()) {
			driverDAO.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
