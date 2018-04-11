package sqltask.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import sqltask.model.entities.*;

public class ControllerUtils {
	
	private static final String DATA_BASE_URL = "jdbc:mysql://localhost/"
			+ "carsanddriver" /*Data Base name*/
				+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	private static final String GET_ALL_DRIVERS_BY_CAR_QUERY = "SELECT cars.manufacturer AS car, cars.model AS model"
															+ ",drivers.name AS name, drivers.phonenumber AS number"
															+ "FROM cars JOIN cardriver ON cars.carid = cardriver.carid"
															+ "JOIN drivers ON drivers.driverid = cardriver.driverid;";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DATA_BASE_URL, USER, PASSWORD);
	}
	
	public Set<Car> getDriverToAllCars(Connection connection) {
		Set<Car> result = new HashSet<>();
		Car car = null;
		Driver driver = null;
		ResultSet rs = null;
		try(Statement statement = connection.createStatement();) {
			rs = statement.executeQuery(GET_ALL_DRIVERS_BY_CAR_QUERY);
			while(rs.next()) {
				car = new Car();
				driver = new Driver();
				car.setIdcar(rs.getInt("carid"));
				car.setModel(rs.getString("model"));
				car.setManufacturer(rs.getString("manufacturer"));
				driver.setDriverId(rs.getInt("driverid"));
				driver.setName(rs.getString("name"));
				driver.setPhoneNumber(rs.getString("phonenumber"));
				
				if (result.contains(car)) {
					
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	

}
