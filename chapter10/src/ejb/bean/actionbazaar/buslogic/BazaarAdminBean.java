package actionbazaar.buslogic;

import actionbazaar.persistence.*;
import javax.annotation.*;
import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.*;

@Stateless(name="BazaarAdmin")
public class BazaarAdminBean implements BazaarAdmin {

  @PersistenceContext      
       private EntityManager em; 
       
    public BazaarAdminBean() {
    }
    
    /* Demonstrates Dynamic Query, Positional Parameter and Single Result */

    public Category findByFullCategoryName(String categoryName) {
          Query query = em.createQuery(
                      "SELECT c FROM Category c WHERE c.categoryName =?1");
            query.setParameter(1,"Recycle");         
            return (Category) query.getSingleResult();   
      }
   

    /* Demonstrates  NamedQuery with Named Parameter, Paginating through a query */    
    
    public List findByCategoryName(String categoryName) {
         Query query =  em.createNamedQuery("findCategoryByName");
			     query.setParameter("categoryName", '%'+categoryName+'%');
                       query.setMaxResults(10);
                       query.setFirstResult(3);
	    List categories = query.getResultList();
         return categories;            
      }

	public List findByUser(String userId) {
         Query query =  em.createNamedQuery("findCategoryByUser");
	   query.setParameter(1, userId);
         List categories = query.getResultList();
         return categories;
      }

	/* Demonstrates  NamedQuery with a date type as parameter */
      public List getItemByDate(Date currentDate) {
         return  em.createNamedQuery("findItemByDate")
			      .setParameter("currentDate", currentDate,TemporalType.DATE)
                       	.getResultList();  

      }
      public List getItemByPriceRange(Double lowPrice,Double highPrice) {
         return  em.createNamedQuery("findItemByInitialPrice")
			      .setParameter("lowPrice", lowPrice)
 				.setParameter("highPrice", highPrice)
                       	.getResultList();  

      }
      
     public List getUserWithItems() {
         return  em.createNamedQuery("findUserWithItems")
			  .getResultList();  

      }

     public List getUserWithNoItems() {
         return  em.createNamedQuery("findUserWithNoItems")
			  .getResultList();  

      }
   
     /* Demonstrates  Dynamic Native query */        

     public List getUserWithItemsWithNativeQuery(){
        Query q = em.createNativeQuery("select user_id, first_name, last_name from users"
						  + " where user_id in (select seller_id from "
						  + "items group by seller_id having count(*) >1)", actionbazaar.persistence.User.class); 
	  return q.getResultList();
      
        }

    /* Demonstrates  Named Native query */        

      public List getUserWithItemsWithNamedNativeQuery(){
              return  em.createNamedQuery("findUserWithMoreItems")
                    .setParameter(1,5)
			  .getResultList();  

       }

}
