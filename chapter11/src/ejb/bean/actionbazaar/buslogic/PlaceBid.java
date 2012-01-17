package actionbazaar.buslogic;

import java.rmi.RemoteException;

import javax.ejb.Remote;
import actionbazaar.persistence.*;

@Remote
public interface PlaceBid {
    public Bid addBid(String bidderId, Long itemId, Double bidPrice);
}
