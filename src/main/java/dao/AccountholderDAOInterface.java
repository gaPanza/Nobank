package dao;

import java.io.Serializable;
import java.util.List;

import model.Accountholder;

public interface AccountholderDAOInterface<T, Id extends Serializable> {
	public void persist(T entity);

	public void update(T entity);

	public T findById(Id id);

	public void delete(T entity);

	public List<T> findAll();

	public void deleteAll();

	public Accountholder findByCpfAndPassword(Long cpf, String password);

}
