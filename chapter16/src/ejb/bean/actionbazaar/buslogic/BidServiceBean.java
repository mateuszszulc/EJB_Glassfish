package actionbazaar.buslogic;


import actionbazaar.persistence.*;
import actionbazaar.persistence.eao.*;

public class BidServiceBean implements BidService  {

protected ItemEAO itemEAO;
protected BidEAO bidEAO ;
 				
 
    public BidServiceBean() {
      System.out.println("Bean Constructor ..");
    }
   
  

  // setters injection
  public void setItemEAO(ItemEAO itemEAO) {
    this.itemEAO = itemEAO;
    System.out.println("Item EAO Injection done ..");

  }

  public void setBidEAO(BidEAO bidEAO) {
    this.bidEAO = bidEAO;
    System.out.println("Bid EAO Injection done ..");

  }


    public Long addBid(String userId, Long itemId, Double bidPrice){
        System.out.println("Bid for "+itemId+ " received with price"+bidPrice);
        System.out.println("Creating bid ..");

       Item item = itemEAO.findByItemId(itemId);
       if (item == null)
       {
         throw new BidException("No such item with Id:"+itemId);
        }
       
      if (bidPrice <= item.getInitialPrice())
       {
         throw new BidException("Price is lower than initial price:");
        }


       Bid highBid = itemEAO.findHighestBidForItem(item);
        if (highBid !=null)
        {
        	System.out.println("Highest Bid Id:"+highBid.getBidId()+" Price:"+highBid.getBidPrice());
        	System.out.println("Current Bid Price:"+bidPrice);
        

        	if (bidPrice <= highBid.getBidPrice())
           		throw new BidException("Bid Price is lower than the current bid price");
           } 
        		Bid bid = this.bidEAO.addBid(itemId, userId, bidPrice);
                        return bid.getBidId();
            
        	
        }

}
