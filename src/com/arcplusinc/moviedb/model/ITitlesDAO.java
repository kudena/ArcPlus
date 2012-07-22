package com.arcplusinc.moviedb.model;

import java.util.List;

/**
 * Interface for TitlesDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ITitlesDAO {
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
	 * ITitlesDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Titles entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Titles entity);

	/**
	 * Delete a persistent Titles entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ITitlesDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Titles entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Titles entity);

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
	 * entity = ITitlesDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Titles entity to update
	 * @return Titles the persisted Titles entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Titles update(Titles entity);

	public Titles findById(Integer id);

	/**
	 * Find all Titles entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Titles property to query
	 * @param value
	 *            the property value to match
	 * @return List<Titles> found by query
	 */
	public List<Titles> findByProperty(String propertyName, Object value);

	public List<Titles> findByTitles(Object titles);

	public List<Titles> findByOwn(Object own);

	public List<Titles> findByFormat(Object format);

	public List<Titles> findByRating(Object rating);

	public List<Titles> findByOnloan(Object onloan);

	public List<Titles> findByImdbref(Object imdbref);

	/**
	 * Find all Titles entities.
	 * 
	 * @return List<Titles> all Titles entities
	 */
	public List<Titles> findAll();
}