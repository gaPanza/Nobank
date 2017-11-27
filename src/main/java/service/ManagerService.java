package service;

import java.util.List;

import model.Accountholder;
import model.Manager;

public interface ManagerService {
	public void persist(Manager entity);

	public void update(Manager entity);

	public Manager findById(String id);

	public void delete(String id);

	public List<Manager> findAll();

	public void deleteAll();

	public Manager findByCpfAndPassword(Long cpf, String password);
	
	public List<Accountholder> allControled(Long cpf);
}
