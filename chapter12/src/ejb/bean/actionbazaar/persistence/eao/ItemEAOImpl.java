package  actionbazaar.persistence.eao;
import actionbazaar.persistence.*;
import javax.persistence.*;
import javax.naming.*;

public class ItemEAOImpl implements ItemEAO {
  
    private static String EM_NAME = "java:comp/env/actionBazaar";

    public ItemEAOImpl() {
    }

    private EntityManager getEntityManager() {
      try 
     {
      	Context ctx = new InitialContext();
      	return (EntityManager) ctx.lookup(EM_NAME);
     }
      catch (Exception e)
      {
       System.out.println("Unable to get an Entity Manager Instance");
       e.printStackTrace();
       return null;
       }
    }

    public Item addItem(Item item) {
     	EntityManager em = getEntityManager();
     	em.persist(item);
     	return item;
    }

    public Item findByItemId(Long itemId) {
     	  EntityManager em = getEntityManager();
     	  return em.find(Item.class,itemId);
    }

    public Bid findHighestBidForItem(Item item) {
     	EntityManager em = getEntityManager();
     	Query query = em.createQuery("select b from Bid as b " +
					    "where b.item=:item" +
					    " and b.bidPrice = (select max(b2.bidPrice) "+
                                  "from Bid as b2 where b2.item=b.item)");
     	query.setParameter("item",item);
      try {
           Bid bid = (Bid) query.getSingleResult();
      	return bid;
      }
      catch (javax.persistence.NoResultException e)
      {
       return null;
       }
      
    }

   
   }
