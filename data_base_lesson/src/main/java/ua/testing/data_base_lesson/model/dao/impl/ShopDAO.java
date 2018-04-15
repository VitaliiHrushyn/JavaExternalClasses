package ua.testing.data_base_lesson.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.testing.data_base_lesson.model.dao.DAOFactory;
import ua.testing.data_base_lesson.model.dao.GenericDAO;
import ua.testing.data_base_lesson.model.entity.Manufacturer;
import ua.testing.data_base_lesson.model.entity.Shop;

public class ShopDAO extends GenericDAO<Shop> {
	
	private static final String GET_BY_ID = "SELECT * FROM shop WHERE idshop = ?;";
	private static final String GET_ALL = "SELECT * FROM shop;";
	private static final String INSERT_SHOP = "INSER INTO shop (name, telephone, idmanufacturer) values (?, ?, ?);";
	private static final String DELETE_SHOP = "DELETE FROM shop WHERE idshop = ?;";
	private static final String UPDATE_SHOP = "UPDATE shop set name = ?, telephone = ?, idmanufacturer = ? WHERE idshop = ?;";

	private static final String ID = "idshop";
	private static final String NAME = "name";
	private static final String TELEPHONE = "telephone";
	private static final String IDMANUFACTURER = "idmanufacturer";

	public ShopDAO(Connection connection) {
		super(connection);
	}

	@Override
	public String getCreateQuery(Shop entity) {
		return INSERT_SHOP;
	}
	
	@Override
	public void fillCreateStatement(PreparedStatement statement, Shop shop) throws SQLException {
		statement.setString(1, shop.getName());
		statement.setString(2, shop.getPhoneNumber());
		statement.setInt(3, shop.getManufacturer().getId());		
	}

	@Override
	public void fillIdStatement(PreparedStatement statement, Shop shop) throws SQLException {
		statement.setInt(1, shop.getId());		
	}
	
	@Override
	public void fillIdStatement(PreparedStatement statement, int id) throws SQLException {
		statement.setInt(1, id);		
	}

	@Override
	public Shop extractEntity(ResultSet rs) throws SQLException {
		Shop shop = new Shop();
		shop.setId(rs.getInt(ID));
		shop.setName(rs.getString(NAME));
		shop.setPhoneNumber(rs.getString(TELEPHONE));
		shop.setManufacturer(extractUniqueManufacturer(rs));
		return shop;
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
	public void fillUpdateStatement(PreparedStatement statement, Shop shop) throws SQLException {
		statement.setString(1, shop.getName());
		statement.setString(2, shop.getPhoneNumber());
		statement.setInt(3, shop.getManufacturer().getId());
		statement.setInt(4, shop.getId());		
	}

	@Override
	public String getUpdateQuery(Shop entity) {
		return UPDATE_SHOP;
	}

	@Override
	public String getDeleteQuery() {
		return DELETE_SHOP;
	}

	@Override
	public String getAllQuery() {
		return GET_ALL;
	}

}
