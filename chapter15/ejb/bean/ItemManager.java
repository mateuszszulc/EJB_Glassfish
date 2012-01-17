package actionbazaar.buslogic;

import actionbazaar.persistence.*;

import java.rmi.RemoteException;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface ItemManager {
    
    public Item addItem(String title, String description,Double initialPrice, String sellerId) ;
    public Item updateItem(Item item);
    public Item undoItemChanges(Item item);
       public void deleteItem(Item item); 
   
}
