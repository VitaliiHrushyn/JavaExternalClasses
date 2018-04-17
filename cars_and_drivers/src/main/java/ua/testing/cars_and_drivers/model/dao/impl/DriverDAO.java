package ua.testing.cars_and_drivers.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ua.testing.cars_and_drivers.model.dao.DAOFactory;
import ua.testing.cars_and_drivers.model.dao.GenericDAO;
import ua.testing.cars_and_drivers.model.entity.Car;
import ua.testing.cars_and_drivers.model.entity.Driver;

public class DriverDAO extends GenericDAO<Driver> {

	public DriverDAO(Connection connection) {
		super(connection);
	}
	
	private static final String DB_NAME = "driver";
	private static final String ID = "iddriver";
	private static final String CAR_ID = "car.idcar";
	private static final String NAME = "driver.name";
	private static final String PHONE = "phone";

	private static final String GET_BY_ID = "SELECT * FROM " + DB_NAME + " WHERE " + ID + " = ?;";
	private static final String GET_ALL = "SELECT * FROM  driver "
				+ "JOIN car_driver ON driver.iddriver = car_driver.iddriver "
				+ "JOIN car ON car.idcar = car_driver.idcar;";
	private static final String GET_WHERE = "SELECT * FROM car "
			+ "JOIN car_driver ON car.idcar = car_driver.idcar "
			+ "JOIN driver ON driver.iddriver = car_driver.iddriver "
			+ " WHERE " + CAR_ID + " = ?;";
	private static final String INSERT = "INSER INTO " + DB_NAME + " (" + NAME + ", " + PHONE + ") values (?, ?);";
	private static final String DELETE = "DELETE FROM " + DB_NAME + " WHERE " + ID + " = ?;";
	private static final String UPDATE = "UPDATE " + DB_NAME + " set " + NAME + " = ?, " + PHONE + " = ?, WHERE " + ID + " = ?;";

	@Override
	public String getCreateQuery(Driver entity) {
		return INSERT;
	}
	
	@Override
	public void fillCreateStatement(PreparedStatement statement, Driver driver) throws SQLException {
		statement.setString(1, driver.getName());
		statement.setString(2, driver.getPhone());
	}

	@Override
	public void fillIdStatement(PreparedStatement statement, Driver driver) throws SQLException {
		statement.setInt(1, driver.getId());		
	}
	
	@Override
	public void fillIdStatement(PreparedStatement statement, int id) throws SQLException {
		statement.setInt(1, id);		
	}

	@Override
	public Driver extractEntity(ResultSet rs, boolean eager) throws SQLException {
		Driver driver = new Driver();
		driver.setId(rs.getInt(ID));
		driver.setName(rs.getString(NAME));
		driver.setPhone(rs.getString(PHONE));
		if (eager) {
			driver.setCars(extractUniqueCars(rs));
		}
		return driver;
	}
	
	private List<Car> extractUniqueCars(ResultSet rs) throws SQLException {
		GenericDAO<Car> carDAO = DAOFactory.getInstance().createCarDAO();
		List<Car> cars = carDAO.getWhere(rs.getInt(ID));
		return cars;
	}

	@Override
	public String getByIDQuery() {
		return GET_BY_ID;
	}

	@Override
	public void fillUpdateStatement(PreparedStatement statement, Driver driver) throws SQLException {
		statement.setString(1, driver.getName());
		statement.setString(2, driver.getPhone());
		statement.setInt(3, driver.getId());		
	}

	@Override
	public String getUpdateQuery(Driver entity) {
		return UPDATE;
	}

	@Override
	public String getDeleteQuery() {
		return DELETE;
	}

	@Override
	public String getAllQuery() {
		return GET_ALL;
	}

	@Override
	public String getWhereQuery() {
		return GET_WHERE;
	}

}
