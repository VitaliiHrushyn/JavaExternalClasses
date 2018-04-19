package ua.training.carsanddrivers.model.services;

import ua.training.carsanddrivers.model.dao.DAOFactory;
import ua.training.carsanddrivers.model.dao.GenericDAO;
import ua.training.carsanddrivers.model.entity.Driver;

public class CreateDriverService {
	
	public void create(String name, String phone) {
		
		try(GenericDAO<Driver> driverDAO = DAOFactory.getInstance().createDriverDAO()) {
			Driver driver = new Driver();		
			driver.setName(name);
			driver.setPhone(phone);		
			driverDAO.create(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
