package ua.testing.data_base_lesson.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ua.testing.data_base_lesson.model.dao.impl.CarDAO;
import ua.testing.data_base_lesson.model.dao.impl.ManufacturerDAO;
import ua.testing.data_base_lesson.model.dao.impl.ShopDAO;

public class JDBCDAOFactory extends DAOFactory {
	
	private static final String DRIVER = MySQLConnectionConstants.MYSQL_DRIVER_NAME;
	private static final String URL = MySQLConnectionConstants.MYSQL_CONNECTION_URL;
	private static final String USERNAME = MySQLConnectionConstants.MYSQL_CONNECTION_USERNAME;
	private static final String PASSWORD = MySQLConnectionConstants.MYSQL_CONNECTION_PASSWORD;
	
	private Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	//	return null;
	}

	@Override
	public CarDAO createCarDAO() {
		return new CarDAO(getConnection());
	}

	@Override
	public ManufacturerDAO createManufacturerDAO() {
		return new ManufacturerDAO(getConnection());
	}

	@Override
	public ShopDAO createShopDAO() {
		return new ShopDAO(getConnection());
	}
	
	

}
 