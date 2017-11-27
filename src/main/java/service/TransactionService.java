package service;

import java.util.List;

import model.Accountholder;
import model.TransactionTransfer;

public interface TransactionService {

	boolean persistTransfer(TransactionTransfer entity);

	List<TransactionTransfer> findTopTransactions(Accountholder accountholder);

}
