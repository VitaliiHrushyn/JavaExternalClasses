package ua.training.carsanddrivers.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CarDriverDAO implements AutoCloseable {
	
	private static final String INSERT = "INSERT INTO car_driver VALUES (?, ?);";
	private static final String UPDATE_CAR = "UPDATE car_driver SET idcar = ? WHERE iddriver = ?;";
	private Connection connection;

	public CarDriverDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public void insert(int carId, int driverId) throws SQLException {
		try(PreparedStatement statement = connection.prepareStatement(INSERT)) {
			statement.setInt(1, carId);
			statement.setInt(2, carId);
			statement.executeUpdate();
		}		
	}
	
	public void update(int carId, int driverId) throws SQLException {
		try(PreparedStatement statement = connection.prepareStatement(UPDATE_CAR)) {
			statement.setInt(1, carId);
			statement.setInt(2, carId);
			statement.executeUpdate();
		}			
	}	
	

	@Override
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}		
	}		
	

}
