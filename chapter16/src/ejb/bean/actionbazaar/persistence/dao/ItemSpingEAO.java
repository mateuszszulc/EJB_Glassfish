package  actionbazaar.persistence.eao;
import actionbazaar.persistence.*;
import javax.persistence.*;
import javax.naming.*;
import java.util.*;

public class ItemSpingEAO extends BasicSpringEAO implements ItemEAO {
  
    public ItemSpingEAO() {
       System.out.println("Item EAO Initialized ..");
    }

   
    public Item addItem(Item item) {
     	getJpaTemplate().persist(item);
     	return item;
    }

    public Item findByItemId(Long itemId) {
             System.out.println("Finding Item.."+itemId);
         	 return (Item) getJpaTemplate().find(Item.class,itemId);
    }

    public Bid findHighestBidForItem(Item item) {
            String queryString = "select b from Bid as b where b.item=?1 and b.bidPrice = (select max(b2.bidPrice) from Bid as b2 where b2.item=b.item)";
     	     	List<Bid> bids = (List<Bid>) getJpaTemplate().find(queryString,item);
      if (bids.isEmpty())
         return null;
        Iterator i = bids.iterator();
      
     Bid bid = (Bid) i.next();
     return bid;
    }

   
   }
