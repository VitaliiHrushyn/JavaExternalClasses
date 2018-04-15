package ua.testing.data_base_lesson.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.testing.data_base_lesson.model.dao.GenericDAO;
import ua.testing.data_base_lesson.model.entity.Manufacturer;

public class ManufacturerDAO extends GenericDAO<Manufacturer> {

	public ManufacturerDAO(Connection connection) {
		super(connection);
	}

	private static final String GET_BY_ID = "SELECT * FROM manufacturer WHERE idmanufacturer = ?;";
	private static final String GET_ALL = "SELECT * FROM manufacturer;";
	private static final String INSERT = "INSER INTO manufacturer (manufacture, discount) values (?, ?);";
	private static final String DELETE = "DELETE FROM manufacturer WHERE idmanufacturer = ?;";
	private static final String UPDATE = "UPDATE manufacturer set manufacture = ?, discont = ?, WHERE idmanufacturer = ?;";

	private static final String ID = "idmanufacturer";
	private static final String MANUFACTURE = "manufacture";
	private static final String DISCOUNT = "discount";

	@Override
	public String getCreateQuery(Manufacturer entity) {
		return INSERT;
	}
	
	@Override
	public void fillCreateStatement(PreparedStatement statement, Manufacturer manufacturer) throws SQLException {
		statement.setString(1, manufacturer.getManufacture());
		statement.setInt(2, manufacturer.getDiscount());
	}

	@Override
	public void fillIdStatement(PreparedStatement statement, Manufacturer manufacturer) throws SQLException {
		statement.setInt(1, manufacturer.getId());		
	}
	
	@Override
	public void fillIdStatement(PreparedStatement statement, int id) throws SQLException {
		statement.setInt(1, id);		
	}

	@Override
	public Manufacturer extractEntity(ResultSet rs) throws SQLException {
		Manufacturer manufacturer = new Manufacturer();
		manufacturer.setId(rs.getInt(ID));
		manufacturer.setManufacture(rs.getString(MANUFACTURE));
		manufacturer.setDiscount(rs.getInt(DISCOUNT));
		return manufacturer;
	}

	@Override
	public String getByIDQuery() {
		return GET_BY_ID;
	}

	@Override
	public void fillUpdateStatement(PreparedStatement statement, Manufacturer manufacturer) throws SQLException {
		statement.setString(1, manufacturer.getManufacture());
		statement.setInt(2, manufacturer.getDiscount());
		statement.setInt(3, manufacturer.getId());		
	}

	@Override
	public String getUpdateQuery(Manufacturer entity) {
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
