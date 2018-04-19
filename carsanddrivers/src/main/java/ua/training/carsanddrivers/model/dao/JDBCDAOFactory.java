package ua.training.carsanddrivers.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ua.training.carsanddrivers.model.dao.impl.CarDAO;
import ua.training.carsanddrivers.model.dao.impl.CarDriverDAO;
import ua.training.carsanddrivers.model.dao.impl.DriverDAO;

public class JDBCDAOFactory extends DAOFactory {
	
	private static final String DRIVER = ConnectionConstants.MYSQL_DRIVER_NAME;
	private static final String URL = ConnectionConstants.MYSQL_CONNECTION_URL;
	private static final String USERNAME = ConnectionConstants.MYSQL_CONNECTION_USERNAME;
	private static final String PASSWORD = ConnectionConstants.MYSQL_CONNECTION_PASSWORD;
	
	private Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public CarDAO createCarDAO() {
		return new CarDAO(getConnection());
	}

	@Override
	public DriverDAO createDriverDAO() {
		return new DriverDAO(getConnection());
	}
	
	@Override
	public CarDriverDAO createCarDriverDAO() {
		return new CarDriverDAO(getConnection());
	}

}
 