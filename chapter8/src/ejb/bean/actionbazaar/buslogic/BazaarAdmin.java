package actionbazaar.buslogic;

import java.rmi.RemoteException;

import javax.ejb.Remote;

import actionbazaar.persistence.Bidder;
import actionbazaar.persistence.Category;
import actionbazaar.persistence.Item;

@Remote
public interface BazaarAdmin {
    Category mergeCategory(Category category) throws RemoteException;


    Category refreshCategory(Category category);


    void removeCategory(Category category);


    Category createCategory(String name, String userId);


    public Bidder createBidder(Bidder bidder);


    Item createItem(String name, String userId, Long categoryId,
            Double initialPrice) throws RemoteException;

}