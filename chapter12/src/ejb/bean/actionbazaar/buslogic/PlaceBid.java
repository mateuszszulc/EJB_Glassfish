package actionbazaar.buslogic;

import java.rmi.RemoteException;

import javax.ejb.Remote;

@Remote
public interface PlaceBid {
    Long addBid(String userId, Long itemId, Double bidPrice);
}
