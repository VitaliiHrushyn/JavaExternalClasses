package ua.training.carsanddrivers.model.dao;

import java.util.List;

public interface GenericDAO<E> extends AutoCloseable {
	
	E create(E entity);
	
	E update(E entity);
	
	E getById(int id);
	
	List<E> getAll(boolean eager);
	
	E delete(E entity);

	E delete(int id);

}
