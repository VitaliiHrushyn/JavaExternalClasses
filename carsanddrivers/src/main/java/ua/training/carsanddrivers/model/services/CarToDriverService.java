package ua.training.carsanddrivers.model.services;

import ua.training.carsanddrivers.model.dao.DAOFactory;
import ua.training.carsanddrivers.model.dao.impl.CarDriverDAO;

public class CarToDriverService {
	
	public void addCarToDriver(int carId, int driverId) {
		
		try (CarDriverDAO carDriverDAO = DAOFactory.getInstance().createCarDriverDAO()) {
			carDriverDAO.insert(carId, driverId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public void deleteCarToDriver(int carId, int driverId) {
		try (CarDriverDAO carDriverDAO = DAOFactory.getInstance().createCarDriverDAO()) {
			carDriverDAO.delete(carId, driverId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
