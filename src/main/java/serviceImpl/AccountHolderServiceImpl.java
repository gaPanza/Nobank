package serviceImpl;

import java.util.List;
import dao.Accountholder;
import dao.AccountholderDAO;
import service.AccountholderService;

public class AccountHolderServiceImpl implements AccountholderService {

	public Accountholder validateLogin(String login, String password) {

		return null;
	}

	private static AccountholderDAO accountHolderDAO;

	public AccountHolderServiceImpl() {
		accountHolderDAO = new AccountholderDAO();
	}

	public void persist(Accountholder entity) {
		accountHolderDAO.openSessionWithTransaction();
		accountHolderDAO.persist(entity);
		accountHolderDAO.closeCurrentSessionWithTransaction();
	}

	public void update(Accountholder entity) {
		accountHolderDAO.openSessionWithTransaction();
		accountHolderDAO.update(entity);
		accountHolderDAO.closeCurrentSessionWithTransaction();
	}

	public Accountholder findById(String id) {
		accountHolderDAO.openSession();
		Accountholder accountHolder = accountHolderDAO.findById(id);
		accountHolderDAO.closeCurrentSession();
		return accountHolder;
	}

	public void delete(String id) {
		accountHolderDAO.openSessionWithTransaction();
		Accountholder accountHolder = accountHolderDAO.findById(id);
		accountHolderDAO.delete(accountHolder);
		accountHolderDAO.closeCurrentSessionWithTransaction();
	}

	public List<Accountholder> findAll() {
		accountHolderDAO.openSession();
		List<Accountholder> books = accountHolderDAO.findAll();
		accountHolderDAO.closeCurrentSession();
		return books;
	}

	public void deleteAll() {
		accountHolderDAO.openSessionWithTransaction();
		accountHolderDAO.deleteAll();
		accountHolderDAO.closeCurrentSessionWithTransaction();
	}

	public AccountholderDAO bookDao() {
		return accountHolderDAO;
	}

}
