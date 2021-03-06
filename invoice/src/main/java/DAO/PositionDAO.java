package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.resource.transaction.spi.TransactionStatus;

import entity.Invoice;
import entity.Position;

public class PositionDAO {

	private EntityManager em;
	private static PositionDAO instance = new PositionDAO();

	public static PositionDAO getInstance()
	{
		return instance;
	}
	
	private PositionDAO()
	{
		this.em = JpaInitializer.getInstance().getEm();
	}
	
	public List<Position> getPositions(Invoice i)
	{
		return (List<Position>) em.createQuery("FROM Position p WHERE Invoice =:i").setParameter("i", i.getNumber()).getResultList();
	}
	
	public void addPosition(Position p)
	{
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(p);
		et.commit();
	}
	
	public void deleteByInvoice(Invoice i)
	{
		EntityTransaction et = em.getTransaction();
		et.begin();
		for(Position p: i.getPositions())
		{
		Object managed = em.merge(p);
		em.remove(managed);
		}
		et.commit();
	}
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
}
