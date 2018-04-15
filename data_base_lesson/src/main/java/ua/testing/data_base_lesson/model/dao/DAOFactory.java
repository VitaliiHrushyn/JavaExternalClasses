package ua.testing.data_base_lesson.model.dao;

import java.util.HashMap;
import java.util.Map;

import ua.testing.data_base_lesson.model.entity.Car;
import ua.testing.data_base_lesson.model.entity.Manufacturer;
import ua.testing.data_base_lesson.model.entity.Shop;

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
	
	public abstract GenericDAO<Manufacturer> createManufacturerDAO();
	
	public abstract GenericDAO<Shop> createShopDAO();

}
