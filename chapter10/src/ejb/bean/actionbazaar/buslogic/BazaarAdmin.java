package actionbazaar.buslogic;

import actionbazaar.persistence.Category;

import actionbazaar.persistence.Item;
import actionbazaar.persistence.User;

import java.rmi.RemoteException;

import java.util.*;

import javax.ejb.Remote;

@Remote
public interface BazaarAdmin {
    public Category findByFullCategoryName(String categoryName);
    public List<Category> findByCategoryName(String categoryName);
    public List getItemByDate(Date currentDate);
    public List getItemByPriceRange(Double lowPrice,Double highPrice);
    public List getUserWithItems();
    public List getUserWithNoItems(); 
    public List getUserWithItemsWithNativeQuery();
    public List getUserWithItemsWithNamedNativeQuery();
    public List findByUser(String userId);
}
