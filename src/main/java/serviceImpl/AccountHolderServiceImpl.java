package serviceImpl;

import java.util.List;

import dao.AccountholderDAO;
import model.Accountholder;
import service.AccountholderService;

//Implementação do serviço para acessar os métodos de transação para AccountHolder.java , com Singleton e Hibernate.

public class AccountHolderServiceImpl implements AccountholderService {

	// Singleton
	private static AccountholderDAO accountHolderDAO;

	public AccountHolderServiceImpl() {
		accountHolderDAO = new AccountholderDAO();
	}

	@Override
	public void persist(Accountholder entity) {
		accountHolderDAO.openSessionWithTransaction();
		accountHolderDAO.persist(entity);
		accountHolderDAO.closeCurrentSessionWithTransaction();
	}

	@Override
	public void update(Accountholder entity) {
		accountHolderDAO.openSessionWithTransaction();
		accountHolderDAO.update(entity);
		accountHolderDAO.closeCurrentSessionWithTransaction();
	}

	@Override
	public Accountholder findById(String id) {
		accountHolderDAO.openSession();
		Accountholder accountHolder = accountHolderDAO.findById(id);
		accountHolderDAO.closeCurrentSession();
		return accountHolder;
	}
	
	@Override
	public Accountholder findByCpf(Long cpf){
		accountHolderDAO.openSession();
		Accountholder accountHolder = accountHolderDAO.findByCpf(cpf);
		accountHolderDAO.closeCurrentSession();
		return accountHolder;
	}

	@Override
	public void delete(String id) {
		accountHolderDAO.openSessionWithTransaction();
		Accountholder accountHolder = accountHolderDAO.findById(id);
		accountHolderDAO.delete(accountHolder);
		accountHolderDAO.closeCurrentSessionWithTransaction();
	}

	@Override
	public List<Accountholder> findAll() {
		accountHolderDAO.openSession();
		List<Accountholder> accountholders = accountHolderDAO.findAll();
		accountHolderDAO.closeCurrentSession();
		return accountholders;
	}

	@Override
	public void deleteAll() {
		accountHolderDAO.openSessionWithTransaction();
		accountHolderDAO.deleteAll();
		accountHolderDAO.closeCurrentSessionWithTransaction();
	}

	@Override
	public Accountholder findByCpfAndPassword(Long cpf, String password) {
		accountHolderDAO.openSessionWithTransaction();
		Accountholder accountholder = accountHolderDAO.findByCpfAndPassword(cpf, password);
		accountHolderDAO.closeCurrentSessionWithTransaction();
		return accountholder;
	}

	public AccountholderDAO accountHolderDAO() {
		return accountHolderDAO;
	}

}
