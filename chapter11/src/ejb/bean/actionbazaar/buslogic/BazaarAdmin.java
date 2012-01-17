package actionbazaar.buslogic;

import actionbazaar.persistence.*;

import java.rmi.RemoteException;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface BazaarAdmin {
    Category mergeCategory(Category category) throws RemoteException;

   
    Category refreshCategory(Category category);

    void removeCategory(Category category);

    Category createCategory(String name, String userId);


    Item createItem(String name, String userId, Long categoryId, 
                    Double initialPrice) throws RemoteException;
   
}
