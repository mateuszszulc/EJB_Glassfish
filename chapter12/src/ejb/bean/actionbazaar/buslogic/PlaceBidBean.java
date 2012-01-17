package actionbazaar.buslogic;


import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import actionbazaar.persistence.*;
import actionbazaar.persistence.eao.*;

@PersistenceContext(unitName="actionBazaar",name="actionBazaar")
@Stateless(name="PlaceBid")
public class PlaceBidBean implements PlaceBid {
 				
 
    public PlaceBidBean() {
    }


    public Long addBid(String userId, Long itemId, Double bidPrice) throws BidException {
        System.out.println("Bid for "+itemId+ " received with price"+bidPrice);
        ItemEAO itemEAO = EAOFactory.JPA.getItemEAO();
        Item item = itemEAO.findByItemId(itemId);
        
        if (item == null)
         {
          throw new BidException("Invalid Item Id:"+ itemId);
         }
        Bid highBid = itemEAO.findHighestBidForItem(item);
        
        if (highBid !=null)
        {
        	System.out.println("Highest Bid Id:"+highBid.getBidId()+" Price:"+highBid.getBidPrice());
        	System.out.println("Current Bid Price:"+bidPrice);
        	if (bidPrice <= highBid.getBidPrice())
           		throw new BidException("Bid Price is lower than the current bid price"); 
        }
        
        BidEAO bidEAO = EAOFactory.JPA.getBidEAO();
        Bid bid = bidEAO.addBid(item, userId, bidPrice);
        return bid.getBidId();

        }

}
