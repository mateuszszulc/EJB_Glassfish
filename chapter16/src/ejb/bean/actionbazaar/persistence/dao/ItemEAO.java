package actionbazaar.persistence.eao;
import actionbazaar.persistence.*;

public interface ItemEAO{
 public Item addItem(Item item);
 public Item findByItemId(Long itemId);
 public Bid findHighestBidForItem(Item item); 
}
