package service;

import java.util.List;

import bean.Accountholder;
import bean.TransactionTransfer;

public interface TransactionService {

	boolean persistTransfer(TransactionTransfer entity);

	List<TransactionTransfer> findTopTransactions(Accountholder accountholder);

}
