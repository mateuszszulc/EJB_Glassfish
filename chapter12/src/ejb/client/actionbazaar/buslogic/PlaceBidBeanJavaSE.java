package actionbazaar.buslogic;


import javax.persistence.*;
import actionbazaar.persistence.*;


public class PlaceBidBeanJavaSE {
    private static EntityManagerFactory emf;
    private static EntityManager em;


    public static void main(String[] args) {
          String userId= "idiot";
          Long itemId = new Long (1);
          Double bidPrice = 2001.50;
  try {

          emf = Persistence.createEntityManagerFactory("actionBazaar");
          getEntityManager();
          addBid(userId,itemId,bidPrice);
          commitTransaction();

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

    private static void commitTransaction() {
     	
       em.getTransaction().commit();
      

    }




    private static Long addBid(String userId, Long itemId, Double bidPrice) throws BidException {
        Item item = em.find(Item.class,itemId);
        if (item == null) 
           throw new BidException("Invalid Item Id");

        Bidder bidder = em.find(Bidder.class,userId);
        if (bidder == null) 
           throw new BidException("Invalid Bidder Id");
        Bid bid = new Bid();
        bid.setItem(item);
        bid.setBidder(bidder);
        bid.setBidPrice(bidPrice);
        em.persist(bid);
        return bid.getBidId();
        }

}
