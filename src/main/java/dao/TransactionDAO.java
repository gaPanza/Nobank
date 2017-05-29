package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import bean.Accountholder;
import bean.TransactionTransfer;

public class TransactionDAO implements TransactionDAOInterface<TransactionTransfer, Serializable> {
	private Session currentSession;
	private Transaction currentTransaction;

	public TransactionDAO() {

	}

	public Session openSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openSessionWithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}

	public void closeCurrentSession() {
		currentSession.close();
	}

	public void closeCurrentSessionWithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}

	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(TransactionTransfer.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	@Override
	public boolean persistTransfer(TransactionTransfer entity) {
		try {
			getCurrentSession().save(entity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TransactionTransfer> findTopTransactions(Accountholder accountholder) {
		List<TransactionTransfer> topTransactions = new ArrayList<TransactionTransfer>();
		Query query = getCurrentSession().createNativeQuery(
				"SELECT * FROM transactiontransfer WHERE idaccountholder = ?1 OR idrecipient = ?2",
				"transactiontransferbyacc");

		query.setParameter(1, accountholder.getId());
		query.setParameter(2, accountholder.getId());
		try {
			topTransactions = (ArrayList<TransactionTransfer>) query.getResultList();
			return topTransactions;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
