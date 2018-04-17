package ua.testing.cars_and_drivers.model.dao;

import ua.testing.cars_and_drivers.model.entity.Car;
import ua.testing.cars_and_drivers.model.entity.Driver;

public abstract class DAOFactory {
	
	private static DAOFactory daoFactory;
	
	public static DAOFactory getInstance() {
		if (daoFactory == null) {
			synchronized (DAOFactory.class) {
				if (daoFactory == null) {
					DAOFactory temp = new JDBCDAOFactory();
					daoFactory = temp;
				}
				
			}
		}
		return daoFactory;
	}
	
	public abstract GenericDAO<Car> createCarDAO();
	
	public abstract GenericDAO<Driver> createDriverDAO();

}
