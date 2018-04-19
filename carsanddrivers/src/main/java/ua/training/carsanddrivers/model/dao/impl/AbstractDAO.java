package ua.training.carsanddrivers.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.training.carsanddrivers.model.dao.GenericDAO;
import ua.training.carsanddrivers.model.entity.Entity;

public abstract class AbstractDAO<E extends Entity> implements GenericDAO<E> {
	
	
	private Connection connection;
	
	public AbstractDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public abstract void fillCreateStatement(PreparedStatement statement, E entity) throws SQLException;

	public abstract String getCreateQuery(E entity);	
	
	public abstract void fillIdStatement(PreparedStatement statement, int id) throws SQLException;
	
	public abstract void fillIdStatement(PreparedStatement statement, E entity) throws SQLException;

	public abstract E extractEntity(ResultSet rs, boolean eager) throws SQLException;

	public abstract String getByIDQuery();
	
	public abstract void fillUpdateStatement(PreparedStatement statement, E entity) throws SQLException;

	public abstract String getUpdateQuery(E entity);
	
	public abstract String getDeleteQuery();
	
	public abstract String getAllQuery();

	@Override
	public E create(E entity) { 
		try(PreparedStatement statement = connection.prepareStatement(getCreateQuery(entity),
																Statement.RETURN_GENERATED_KEYS)) {
			fillCreateStatement(statement, entity);
			System.out.println("DAO stat: "+statement.toString());
			statement.executeUpdate();
			ResultSet keys = statement.getGeneratedKeys();
			int id;
			if (keys.next()) {
				id = keys.getInt(1);
				return getById(id);
			} else {				
				return null;	
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override	
	public E getById(int id) {
		E entity = null;		
		try(PreparedStatement statement = connection.prepareStatement(getByIDQuery())) {
			fillIdStatement(statement, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				entity = extractEntity(rs, true);	
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		return entity;
	}	

	@Override
	public E update(E entity) {
		try(PreparedStatement statement = connection.prepareStatement(getUpdateQuery(entity))) {
			fillUpdateStatement(statement, entity);
			System.out.println("DAO udate: "+statement.toString());
			if (statement.executeUpdate() > 0) {
				return entity;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}	

	@Override
	public E delete(E entity) {
		try(PreparedStatement statement = connection.prepareStatement(getDeleteQuery())) {
			fillIdStatement(statement, entity);
			int res = statement.executeUpdate();
			if (res > 0) {
				return entity;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return null;
	}
	
	@Override
	public E delete(int id) {
		try(PreparedStatement statement = connection.prepareStatement(getDeleteQuery())) {
			fillIdStatement(statement, id);
			int res = statement.executeUpdate();
			if (res > 0) {
				return getById(id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return null;
	}
	
	@Override
	public List<E> getAll(boolean eager) {
		Map<Integer, E> uniqueEnteties = new HashMap<>();
		try(PreparedStatement statement = connection.prepareStatement(getAllQuery())) {
			ResultSet rs = statement.executeQuery();			
			while(rs.next()) {
				E entity = extractEntity(rs, eager);
				uniqueEnteties.putIfAbsent(entity.getId(), entity);;	
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}				
		return new ArrayList<>(uniqueEnteties.values());
	}
	
	public List<E> getWhere(int id) {
		Map<Integer, E> uniqueEnteties = new HashMap<>();
		try(PreparedStatement statement = connection.prepareStatement(getWhereQuery())) {
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();			
			while(rs.next()) {
				E entity = extractEntity(rs, false);
				uniqueEnteties.putIfAbsent(entity.getId(), entity);;	
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}				
		return new ArrayList<>(uniqueEnteties.values());
	}

	public abstract String getWhereQuery();

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
