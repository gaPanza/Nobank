package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import model.Accountholder;
import model.Manager;

public class AccountholderDAO implements AccountholderDAOInterface<Accountholder, Serializable> {
	private Session currentSession;
	private Transaction currentTransaction;

	public AccountholderDAO() {

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
	
	//Factory Method
	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Accountholder.class).addAnnotatedClass(Manager.class);
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
	public void persist(Accountholder entity) {
		getCurrentSession().save(entity);

	}

	@Override
	public void update(Accountholder entity) {
		getCurrentSession().update(entity);

	}

	@Override
	public Accountholder findById(Serializable id) {
		Accountholder Accountholder = (Accountholder) getCurrentSession().get(Accountholder.class, id);

		return Accountholder;
	}

	@Override
	public Accountholder findByCpfAndPassword(Long cpf, String password) {

		Query query = getCurrentSession().createNativeQuery(
				"SELECT * FROM Accountholder WHERE cpf = ?1 AND password = ?2", Accountholder.class);
		query.setParameter(1, cpf);
		query.setParameter(2, password);
		try {
			Accountholder x = (Accountholder) query.getSingleResult();
			return x;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public void delete(Accountholder entity) {
		getCurrentSession().delete(entity);
	}

	@Override
	public List<Accountholder> findAll() {
		@SuppressWarnings("unchecked")
		List<Accountholder> Accountholder = (List<Accountholder>) getCurrentSession().createQuery("from Accountholder")
				.list();

		return Accountholder;

	}

	@Override
	public void deleteAll() {
		List<Accountholder> entityList = findAll();

		for (Accountholder entity : entityList) {

			delete(entity);

		}
	}

	public Accountholder findByCpf(Long cpf) {
		Query query = getCurrentSession().createNativeQuery("SELECT * FROM Accountholder WHERE cpf = ?1",
				Accountholder.class);
		query.setParameter(1, cpf);
		try {
			Accountholder x = (Accountholder) query.getSingleResult();
			return x;
		} catch (NoResultException e) {
			return null;
		}
	}

}
