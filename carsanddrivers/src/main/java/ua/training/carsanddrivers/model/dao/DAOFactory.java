package ua.training.carsanddrivers.model.dao;

import ua.training.carsanddrivers.model.dao.impl.AbstractDAO;
import ua.training.carsanddrivers.model.dao.impl.CarDriverDAO;
import ua.training.carsanddrivers.model.entity.Car;
import ua.training.carsanddrivers.model.entity.Driver;

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
	
	public abstract AbstractDAO<Car> createCarDAO();
	
	public abstract AbstractDAO<Driver> createDriverDAO();
	
	public abstract CarDriverDAO createCarDriverDAO();

}
