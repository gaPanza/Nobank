package serviceImpl;

import java.util.ArrayList;
import java.util.List;

import bean.Accountholder;
import bean.TransactionTransfer;
import dao.TransactionDAO;
import service.TransactionService;

public class TransactionServiceImpl implements TransactionService {

	// Singleton
	private static TransactionDAO transactionDAO;

	public TransactionServiceImpl() {
		transactionDAO = new TransactionDAO();
	}

	@Override
	public boolean persistTransfer(TransactionTransfer entity) {
		transactionDAO.openSessionWithTransaction();
		boolean success = transactionDAO.persistTransfer(entity);
		transactionDAO.closeCurrentSessionWithTransaction();

		return success;

	}

	public TransactionDAO getTransactionDAO() {
		return transactionDAO;
	}

	@Override
	public List<TransactionTransfer> findTopTransactions(Accountholder accountholder) {
		List<TransactionTransfer> topTransactions = new ArrayList<TransactionTransfer>();
		transactionDAO.openSessionWithTransaction();
		topTransactions = transactionDAO.findTopTransactions(accountholder);
		transactionDAO.closeCurrentSessionWithTransaction();
		return topTransactions;
	}

}
