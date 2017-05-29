package dao;

import java.io.Serializable;
import java.util.List;

import bean.Accountholder;
import bean.TransactionTransfer;

public interface TransactionDAOInterface<T, Id extends Serializable> {

	boolean persistTransfer(TransactionTransfer entity);

	List<TransactionTransfer> findTopTransactions(Accountholder accountholder);

}
