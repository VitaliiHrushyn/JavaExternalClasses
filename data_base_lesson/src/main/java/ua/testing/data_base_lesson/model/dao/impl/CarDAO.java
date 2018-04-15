package ua.testing.data_base_lesson.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.testing.data_base_lesson.model.dao.DAOFactory;
import ua.testing.data_base_lesson.model.dao.GenericDAO;
import ua.testing.data_base_lesson.model.entity.Car;
import ua.testing.data_base_lesson.model.entity.Manufacturer;

public class CarDAO extends GenericDAO<Car> {

		public CarDAO(Connection connection) {
			super(connection);
		}

		private static final String GET_BY_ID = "SELECT * FROM car WHERE idcar = ?;";
		private static final String GET_ALL = "SELECT * FROM car;";
		private static final String INSERT = "INSER INTO car (model, price, idmanufacturer) values (?, ?, ?);";
		private static final String DELETE = "DELETE FROM car WHERE idcar = ?;";
		private static final String UPDATE = "UPDATE car set model = ?, price = ?, idmanufacturer = ? WHERE idcars = ?;";

		private static final String ID = "idcar";
		private static final String MODEL = "model";
		private static final String PRICE = "price";
		private static final String IDMANUFACTURER = "idmanufacturer";

		@Override
		public String getCreateQuery(Car entity) {
			return INSERT;
		}
		
		@Override
		public void fillCreateStatement(PreparedStatement statement, Car car) throws SQLException {
			statement.setString(1, car.getModel());
			statement.setString(2, String.valueOf(car.getPrice()));
			statement.setInt(3, car.getManufacturer().getId());
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
		public Car extractEntity(ResultSet rs) throws SQLException {
			Car car = new Car();
			car.setId(rs.getInt(ID));
			car.setModel(rs.getString(MODEL));
			car.setPrice(Long.valueOf(rs.getString(PRICE)));
			car.setManufacturer(extractUniqueManufacturer(rs));
			return car;
		}

		private Manufacturer extractUniqueManufacturer(ResultSet rs) throws SQLException {
			Manufacturer manufacturer = DAOFactory.getInstance().createManufacturerDAO().getById(rs.getInt(IDMANUFACTURER));
			manufacturers.putIfAbsent(manufacturer.getManufacture(), manufacturer);
			return manufacturers.get(manufacturer.getManufacture());
		}

		@Override
		public String getByIDQuery() {
			return GET_BY_ID;
		}

		@Override
		public void fillUpdateStatement(PreparedStatement statement, Car car) throws SQLException {
			statement.setString(1, car.getModel());
			statement.setString(2, String.valueOf(car.getPrice()));
			statement.setInt(3, car.getManufacturer().getId());
			statement.setInt(4, car.getId());		
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

}
