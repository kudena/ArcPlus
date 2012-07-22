package com.arcplusinc.moviedb.model;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Titles entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see com.arcplusinc.moviedb.model.Titles
 * @author MyEclipse Persistence Tools
 */

public class TitlesDAO implements ITitlesDAO {
	// property constants
	public static final String TITLES = "titles";
	public static final String OWN = "own";
	public static final String FORMAT = "format";
	public static final String RATING = "rating";
	public static final String ONLOAN = "onloan";
	public static final String IMDBREF = "imdbref";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved Titles entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * TitlesDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Titles entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Titles entity) {
		EntityManagerHelper.log("saving Titles instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Titles entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * TitlesDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Titles entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Titles entity) {
		EntityManagerHelper.log("deleting Titles instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(Titles.class,
					entity.getMkey());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Titles entity and return it or a copy of it to
	 * the sender. A copy of the Titles entity parameter is returned when the
	 * JPA persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = TitlesDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Titles entity to update
	 * @return Titles the persisted Titles entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Titles update(Titles entity) {
		EntityManagerHelper.log("updating Titles instance", Level.INFO, null);
		try {
			Titles result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Titles findById(Integer id) {
		EntityManagerHelper.log("finding Titles instance with id: " + id,
				Level.INFO, null);
		try {
			Titles instance = getEntityManager().find(Titles.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Titles entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Titles property to query
	 * @param value
	 *            the property value to match
	 * @return List<Titles> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Titles> findByProperty(String propertyName, final Object value) {
		EntityManagerHelper.log("finding Titles instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Titles model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	public List<Titles> findByTitles(Object titles) {
		return findByProperty(TITLES, titles);
	}

	public List<Titles> findByOwn(Object own) {
		return findByProperty(OWN, own);
	}

	public List<Titles> findByFormat(Object format) {
		return findByProperty(FORMAT, format);
	}

	public List<Titles> findByRating(Object rating) {
		return findByProperty(RATING, rating);
	}

	public List<Titles> findByOnloan(Object onloan) {
		return findByProperty(ONLOAN, onloan);
	}

	public List<Titles> findByImdbref(Object imdbref) {
		return findByProperty(IMDBREF, imdbref);
	}

	/**
	 * Find all Titles entities.
	 * 
	 * @return List<Titles> all Titles entities
	 */
	@SuppressWarnings("unchecked")
	public List<Titles> findAll() {
		EntityManagerHelper.log("finding all Titles instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from Titles model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}