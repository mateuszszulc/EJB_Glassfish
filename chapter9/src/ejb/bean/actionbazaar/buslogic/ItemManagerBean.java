package actionbazaar.buslogic;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import actionbazaar.persistence.Item;
import actionbazaar.persistence.Seller;

@Stateless(name = "ItemManager")
public class ItemManagerBean implements ItemManager {
    @PersistenceContext(unitName = "actionBazaar")
    private EntityManager entityManager;


    public ItemManagerBean() {
    }


    public Item addItem(String title, String description, Double initialPrice,
            String sellerId) {
        Item item = new Item();
        item.setTitle(title);
        item.setInitialPrice(initialPrice);

        Seller seller = entityManager.find(Seller.class, sellerId);
        item.setSeller(seller);
        entityManager.persist(item);
        return item;
    }


    public Item updateItem(Item item) {
        entityManager.merge(item);
        return item;
    }


    public Item undoItemChanges(Item item) {
        entityManager.refresh(entityManager.merge(item));
        return item;
    }


    public void deleteItem(Item item) {
        entityManager.remove(entityManager.merge(item));
    }
}