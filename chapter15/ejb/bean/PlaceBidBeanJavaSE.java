package actionbazaar.buslogic;


import javax.persistence.*;
import actionbazaar.persistence.*;


public class PlaceBidBeanJavaSE {
    private static EntityManagerFactory emf;
    private static EntityManager em;


    public static void main(String[] args) {
          String userId= "idiot";
          Long itemId = new Long (100);
          Double bidPrice = 2001.50;
  try {

          emf = Persistence.createEntityManagerFactory("actionBazaar");
          getEntityManager();
          addBid(userId,itemId,bidPrice);
          closeEntityManager();

    } finally {        
            // close the EntityManager when done
            em.close();
            emf.close();
        }

                        
    }

    private static void getEntityManager() {
     	em = emf.createEntityManager();
     	em.getTransaction().begin();

    }

    private static void closeEntityManager() {
     	
     	em.getTransaction().commit();
       em.close();

    }




    private static Long addBid(String userId, Long itemId, Double bidPrice) throws BidException {
        Item item = em.find(Item.class,itemId);
        Bidder bidder = em.find(Bidder.class,userId);
        Bid bid = new Bid();
        bid.setItem(item);
        bid.setBidder(bidder);
        bid.setBidPrice(bidPrice);
        em.persist(bid);
        return bid.getBidId();
        }

}
