package actionbazaar.buslogic;

import java.util.List;

import javax.ejb.Remote;

import actionbazaar.persistence.Bid;
import actionbazaar.persistence.Item;

@Remote
public interface BidManager {
    Long addBid(Bid bid);


    void cancelBid(Bid bid);


    List<Bid> getBids(Item item);
}