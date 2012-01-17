package actionbazaar.persistence.eao;
import actionbazaar.persistence.*;

public interface BidEAO{
 public Bid addBid(Item item, String bidderId, double bidPrice);
 public Bid cancelBid(Long bidId);
}
