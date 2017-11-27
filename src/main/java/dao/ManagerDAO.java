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

public class ManagerDAO implements ManagerDaoInterface<Manager, Serializable> {
	private Session currentSession;
	private Transaction currentTransaction;

	public ManagerDAO() {
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

	// Factory Method
	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Manager.class).addAnnotatedClass(Accountholder.class);
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
	public void persist(Manager entity) {
		getCurrentSession().save(entity);
	}

	@Override
	public void update(Manager entity) {
		getCurrentSession().update(entity);

	}

	@Override
	public Manager findById(Serializable id) {
		Manager manager = (Manager) getCurrentSession().get(Manager.class, id);

		return manager;
	}

	@Override
	public void delete(Manager entity) {
		getCurrentSession().delete(entity);

	}

	@Override
	public List<Manager> findAll() {
		@SuppressWarnings("unchecked")
		List<Manager> Manager = (List<Manager>) getCurrentSession().createQuery("from Manager").list();

		return Manager;
	}

	@Override
	public void deleteAll() {
		List<Manager> entityList = findAll();

		for (Manager entity : entityList) {

			delete(entity);

		}

	}

	@Override
	public Manager findByCpfAndPassword(Long cpf, String password) {
		Query query = getCurrentSession().createNativeQuery("SELECT * FROM Manager WHERE cpf = ?1 AND password = ?2",
				Manager.class);
		query.setParameter(1, cpf);
		query.setParameter(2, password);
		try {
			Manager x = (Manager) query.getSingleResult();
			return x;
		} catch (NoResultException e) {
			return null;
		}
	}

	public Manager findByCpf(Long cpf) {
		Query query = getCurrentSession().createNativeQuery("SELECT * FROM Manager WHERE cpf = ?1", Manager.class);
		query.setParameter(1, cpf);
		try {
			Manager x = (Manager) query.getSingleResult();
			return x;
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Accountholder> allByManager(Manager manager) {
		openSession();
		Query query = getCurrentSession().createNativeQuery("SELECT * FROM Accountholder WHERE Manager_id = ?1",
				Accountholder.class);
		query.setParameter(1, manager.getId());
		try {
			@SuppressWarnings("unchecked")
			List<Accountholder> resultList = (List<Accountholder>) query.getResultList();
			return resultList;
		} catch (NoResultException e) {
			return null;
		}

	}

}
