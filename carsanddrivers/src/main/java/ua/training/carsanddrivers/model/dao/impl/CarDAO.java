package ua.training.carsanddrivers.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ua.training.carsanddrivers.model.dao.DAOFactory;
import ua.training.carsanddrivers.model.entity.Car;
import ua.training.carsanddrivers.model.entity.Driver;

public class CarDAO extends AbstractDAO<Car> {

		public CarDAO(Connection connection) {
			super(connection);
		}

		private static final String DB_NAME = "car";
		private static final String ID = "car.idcar";
		private static final String DRIVER_ID = "driver.iddriver";
		private static final String NAME = "car.name";
		private static final String NUMBER = "number";
		
		private static final String GET_BY_ID = "SELECT * FROM " + DB_NAME + " WHERE " + ID + " = ?;";
		private static final String GET_ALL = "SELECT * FROM car;";
//				+ "JOIN car_driver ON car.idcar = car_driver.idcar "
//				+ "JOIN driver ON driver.iddriver = car_driver.iddriver;";
		private static final String GET_WHERE = "SELECT * FROM car "
				+ "JOIN car_driver ON car.idcar = car_driver.idcar "
				+ "JOIN driver ON driver.iddriver = car_driver.iddriver "
				+ " WHERE " + DRIVER_ID + " = ?;";
		private static final String INSERT = "INSER INTO " + DB_NAME + " (" + NAME + ", " + NUMBER + ") values (?, ?);";
		private static final String DELETE = "DELETE FROM " + DB_NAME + " WHERE " + ID + " = ?;";
		private static final String UPDATE = "UPDATE " + DB_NAME + " set " + NAME + " = ?, " + NUMBER + " = ? WHERE " + ID + " = ?;";

		@Override
		public String getCreateQuery(Car entity) {
			return INSERT;
		}
		
		@Override
		public void fillCreateStatement(PreparedStatement statement, Car car) throws SQLException {
			statement.setString(1, car.getName());
			statement.setString(2, car.getNumber());
		}

		@Override
		public void fillIdStatement(PreparedStatement statement, Car car) throws SQLException {
			statement.setInt(1, car.getId());		
		}
		
		@Override
		public void fillIdStatement(PreparedStatement statement, int id) throws SQLException {
			statement.setInt(1, id);		
		}

		@Override
		public Car extractEntity(ResultSet rs, boolean eager) throws SQLException {
			Car car = new Car();
			car.setId(rs.getInt(ID));
			car.setName(rs.getString(NAME));
			car.setNumber(rs.getString(NUMBER));
			if (eager) {
				car.setDrivers(extractUniqueDrivers(rs));
			}
			return car;
		}

		private List<Driver> extractUniqueDrivers(ResultSet rs) throws SQLException {
			AbstractDAO<Driver> driverDAO = DAOFactory.getInstance().createDriverDAO();
			List<Driver> drivers = driverDAO.getWhere(rs.getInt(ID));
			return drivers;
		}

		@Override
		public String getByIDQuery() {
			return GET_BY_ID;
		}

		@Override
		public void fillUpdateStatement(PreparedStatement statement, Car car) throws SQLException {
			statement.setString(1, car.getName());
			statement.setString(2, car.getNumber());
			statement.setInt(3, car.getId());		
		}

		@Override
		public String getUpdateQuery(Car entity) {
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
