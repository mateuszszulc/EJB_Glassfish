package  actionbazaar.persistence.eao;
import actionbazaar.persistence.*;
import actionbazaar.buslogic.*;
import javax.persistence.*;
import javax.naming.*;

public class BidSpringEAO extends BasicSpringEAO implements BidEAO {
  
public BidSpringEAO() {
       System.out.println("Bid EAO Initialized ..");
    }

    
    public Bid addBid(Long itemId, String bidderId, double bidPrice) {
      System.out.println("Finding item:"+itemId);
      Bid bid = new Bid();
      Item item =  (Item)this.getJpaTemplate().find(Item.class,itemId);
      bid.setItem(item);
      bid.setBidPrice(bidPrice);
      bid.setBidStatus(BidStatus.NEW);
      System.out.println("Finding Bidder:"+bidderId);
      Bidder bidder =  (Bidder)getJpaTemplate().find(Bidder.class,bidderId);
      if (bidder == null)
       {
         throw new BidException("No such user with Id:"+bidderId);
        }

      System.out.println("Found Bidder:"+bidder.getFirstName());
      bid.setBidder(bidder);
     	this.getJpaTemplate().persist(bid);
      System.out.println("Persisted Bid:");
     	return bid;
    }

   
    public Bid cancelBid(Long bidId) {
      Bid bid =  (Bid) getJpaTemplate().find(Bid.class,bidId);
      bid.setBidStatus(BidStatus.CANCELLED);
     	this.getJpaTemplate().merge(bid);
      return bid;
    }
   
   }
