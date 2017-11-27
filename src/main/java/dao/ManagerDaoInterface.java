package dao;

import java.io.Serializable;
import java.util.List;

import model.Manager;

public interface ManagerDaoInterface<T, Id extends Serializable> {
	public void persist(T entity);
	
	public void update(T entity);
	
	public T findById(Id id);
	
	public void delete(T entity);
	
	public List<T> findAll();

	public void deleteAll();
	
	public Manager findByCpfAndPassword(Long cpf, String password);
}
