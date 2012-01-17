package  actionbazaar.persistence.eao;
import actionbazaar.persistence.*;
import javax.persistence.*;
import actionbazaar.buslogic.*;
import javax.naming.*;

public class BidEAOImpl implements BidEAO {
  
    private static String EM_NAME = "java:comp/env/actionBazaar";

    public BidEAOImpl() {
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

    public Bid addBid(Item item, String bidderId, double bidPrice) {
      Bid bid = new Bid();
      bid.setItem(item);
      bid.setBidPrice(bidPrice);
      bid.setBidStatus(BidStatus.NEW);
     	EntityManager em = getEntityManager();
      System.out.println("Finding Bidder:"+bidderId);
      Bidder bidder =  em.find(Bidder.class,bidderId);
      if (bidder == null)
         {
          throw new BidException("Invalid Bidder Id:"+ bidderId);
         }
      System.out.println("Found Bidder:"+bidder.getFirstName());
      bid.setBidder(bidder);
     	em.persist(bid);
      System.out.println("Persisted Bid:");
     	return bid;
    }

   
    public Bid cancelBid(Long bidId) {
     	EntityManager em = getEntityManager();
      Bid bid =  em.find(Bid.class,bidId);
      bid.setBidStatus(BidStatus.CANCELLED);
     	em.merge(bid);
      return bid;
    }

   
   }
