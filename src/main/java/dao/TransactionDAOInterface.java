package dao;

import java.io.Serializable;
import java.util.List;

import model.Accountholder;
import model.TransactionTransfer;

//Abstract Factory
public interface TransactionDAOInterface<T, Id extends Serializable> {

	boolean persistTransfer(TransactionTransfer entity);

	List<TransactionTransfer> findTopTransactions(Accountholder accountholder);

}
