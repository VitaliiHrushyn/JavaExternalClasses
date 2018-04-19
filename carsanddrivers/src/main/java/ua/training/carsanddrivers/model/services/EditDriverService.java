package ua.training.carsanddrivers.model.services;

import ua.training.carsanddrivers.model.dao.DAOFactory;
import ua.training.carsanddrivers.model.dao.GenericDAO;

import ua.training.carsanddrivers.model.entity.Driver;

public class EditDriverService {
	
	public void edit(int id, String name, String phone) {
		
		try(GenericDAO<Driver> driverDAO = DAOFactory.getInstance().createDriverDAO()) {
			Driver driver = driverDAO.getById(id);		
			driver.setName(name);
			driver.setPhone(phone);		
			driverDAO.update(driver);	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
