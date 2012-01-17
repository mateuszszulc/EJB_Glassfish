package actionbazaar.buslogic;

import javax.ejb.Remote;

import actionbazaar.persistence.Item;

@Remote
public interface ItemManager {

    public Item addItem(String title, String description, Double initialPrice,
            String sellerId);


    public Item updateItem(Item item);


    public Item undoItemChanges(Item item);


    public void deleteItem(Item item);
}