package com.arcplusinc.moviedb.model;

import java.util.List;
import java.util.Set;

/**
 * Interface for DirectorsDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IDirectorsDAO {
		/**
	 Perform an initial save of a previously unsaved Directors entity. 
	 All subsequent persist actions of this entity should use the #update() method.
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 	 
	 * <pre> 
	 *   EntityManagerHelper.beginTransaction();
	 *   IDirectorsDAO.save(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity Directors entity to persist
	  @throws RuntimeException when the operation fails
	 */
    public void save(Directors entity);
    /**
	 Delete a persistent Directors entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IDirectorsDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity Directors entity to delete
	 @throws RuntimeException when the operation fails
	 */
    public void delete(Directors entity);
   /**
	 Persist a previously saved Directors entity and return it or a copy of it to the sender. 
	 A copy of the Directors entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IDirectorsDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity Directors entity to update
	 @return Directors the persisted Directors entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public Directors update(Directors entity);
	public Directors findById( Integer id);
	 /**
	 * Find all Directors entities with a specific property value.  
	 
	  @param propertyName the name of the Directors property to query
	  @param value the property value to match
	  	  @return List<Directors> found by query
	 */
	public List<Directors> findByProperty(String propertyName, Object value
		);
	public List<Directors> findByLastName(Object lastName
		);
	public List<Directors> findByFirstName(Object firstName
		);
	public List<Directors> findByName(Object name
		);
	/**
	 * Find all Directors entities.
	  	  @return List<Directors> all Directors entities
	 */
	public List<Directors> findAll(
		);	
}