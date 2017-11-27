package serviceImpl;

import java.util.ArrayList;
import java.util.List;

import dao.ManagerDAO;
import model.Accountholder;
import model.Manager;
import service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
	// Singleton
	private static ManagerDAO managerDAO;

	public ManagerServiceImpl() {
		managerDAO = new ManagerDAO();
	}

	@Override
	public void persist(Manager entity) {
		managerDAO.openSessionWithTransaction();
		managerDAO.persist(entity);
		managerDAO.closeCurrentSessionWithTransaction();

	}

	@Override
	public void update(Manager entity) {
		managerDAO.openSessionWithTransaction();
		managerDAO.update(entity);
		managerDAO.closeCurrentSessionWithTransaction();

	}

	@Override
	public Manager findById(String id) {
		managerDAO.openSession();
		Manager manager = managerDAO.findById(id);
		managerDAO.closeCurrentSession();
		return manager;
	}

	@Override
	public void delete(String id) {
		managerDAO.openSessionWithTransaction();
		Manager accountHolder = managerDAO.findById(id);
		managerDAO.delete(accountHolder);
		managerDAO.closeCurrentSessionWithTransaction();

	}

	@Override
	public List<Manager> findAll() {
		managerDAO.openSession();
		ArrayList<Manager> manager = (ArrayList<Manager>) managerDAO.findAll();
		managerDAO.closeCurrentSession();
		return manager;
	}

	@Override
	public void deleteAll() {
		managerDAO.openSessionWithTransaction();
		managerDAO.deleteAll();
		managerDAO.closeCurrentSessionWithTransaction();

	}

	@Override
	public Manager findByCpfAndPassword(Long cpf, String password) {
		managerDAO.openSessionWithTransaction();
		Manager accountholder = managerDAO.findByCpfAndPassword(cpf, password);
		managerDAO.closeCurrentSessionWithTransaction();
		return accountholder;
	}

	@Override
	public List<Accountholder> allControled(Long cpf) {
		Manager manager = findByCpf(cpf);
		return managerDAO.allByManager(manager);
	}
	
	private Manager findByCpf(Long cpf){
		managerDAO.openSession();
		Manager manager = managerDAO.findByCpf(cpf);
		managerDAO.closeCurrentSession();
		return manager;
	}
	

}
