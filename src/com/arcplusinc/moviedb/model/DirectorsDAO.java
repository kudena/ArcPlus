package com.arcplusinc.moviedb.model;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for Directors entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see com.arcplusinc.moviedb.model.Directors
  * @author MyEclipse Persistence Tools 
 */

public class DirectorsDAO  implements IDirectorsDAO{
	//property constants
	public static final String LAST_NAME = "lastName";
	public static final String FIRST_NAME = "firstName";
	public static final String NAME = "name";





	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
		/**
	 Perform an initial save of a previously unsaved Directors entity. 
	 All subsequent persist actions of this entity should use the #update() method.
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 	 
	 * <pre> 
	 *   EntityManagerHelper.beginTransaction();
	 *   DirectorsDAO.save(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity Directors entity to persist
	  @throws RuntimeException when the operation fails
	 */
    public void save(Directors entity) {
    				EntityManagerHelper.log("saving Directors instance", Level.INFO, null);
	        try {
            getEntityManager().persist(entity);
            			EntityManagerHelper.log("save successful", Level.INFO, null);
	        } catch (RuntimeException re) {
        				EntityManagerHelper.log("save failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    /**
	 Delete a persistent Directors entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   DirectorsDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity Directors entity to delete
	 @throws RuntimeException when the operation fails
	 */
    public void delete(Directors entity) {
    				EntityManagerHelper.log("deleting Directors instance", Level.INFO, null);
	        try {
        	entity = getEntityManager().getReference(Directors.class, entity.getDkey());
            getEntityManager().remove(entity);
            			EntityManagerHelper.log("delete successful", Level.INFO, null);
	        } catch (RuntimeException re) {
        				EntityManagerHelper.log("delete failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    /**
	 Persist a previously saved Directors entity and return it or a copy of it to the sender. 
	 A copy of the Directors entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = DirectorsDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity Directors entity to update
	 @return Directors the persisted Directors entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
    public Directors update(Directors entity) {
    				EntityManagerHelper.log("updating Directors instance", Level.INFO, null);
	        try {
            Directors result = getEntityManager().merge(entity);
            			EntityManagerHelper.log("update successful", Level.INFO, null);
	            return result;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("update failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    public Directors findById( Integer id) {
    				EntityManagerHelper.log("finding Directors instance with id: " + id, Level.INFO, null);
	        try {
            Directors instance = getEntityManager().find(Directors.class, id);
            return instance;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("find failed", Level.SEVERE, re);
	            throw re;
        }
    }    
    

/**
	 * Find all Directors entities with a specific property value.  
	 
	  @param propertyName the name of the Directors property to query
	  @param value the property value to match
	  	  @return List<Directors> found by query
	 */
    @SuppressWarnings("unchecked")
    public List<Directors> findByProperty(String propertyName, final Object value
        ) {
    				EntityManagerHelper.log("finding Directors instance with property: " + propertyName + ", value: " + value, Level.INFO, null);
			try {
			final String queryString = "select model from Directors model where model." 
			 						+ propertyName + "= :propertyValue";
								Query query = getEntityManager().createQuery(queryString);
					query.setParameter("propertyValue", value);
					return query.getResultList();
		} catch (RuntimeException re) {
						EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
				throw re;
		}
	}			
	public List<Directors> findByLastName(Object lastName
	) {
		return findByProperty(LAST_NAME, lastName
		);
	}
	
	public List<Directors> findByFirstName(Object firstName
	) {
		return findByProperty(FIRST_NAME, firstName
		);
	}
	
	public List<Directors> findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	
	/**
	 * Find all Directors entities.
	  	  @return List<Directors> all Directors entities
	 */
	@SuppressWarnings("unchecked")
	public List<Directors> findAll(
		) {
					EntityManagerHelper.log("finding all Directors instances", Level.INFO, null);
			try {
			final String queryString = "select model from Directors model";
								Query query = getEntityManager().createQuery(queryString);
					return query.getResultList();
		} catch (RuntimeException re) {
						EntityManagerHelper.log("find all failed", Level.SEVERE, re);
				throw re;
		}
	}
	
}