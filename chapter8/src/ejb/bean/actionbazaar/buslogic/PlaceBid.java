package actionbazaar.buslogic;

import javax.ejb.Remote;

import actionbazaar.persistence.Bid;

@Remote
public interface PlaceBid {
    public Bid addBid(String bidderId, Long itemId, Double bidPrice);
}