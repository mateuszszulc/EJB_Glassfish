package actionbazaar.buslogic;
import javax.ejb.EJB;
import actionbazaar.persistence.*;
import java.util.*;


public class BazaarAdminClient {
@EJB
private static BazaarAdmin bazaarAdmin;
    public static void main(String [] args) {
            
            System.out.println("Finding categories By name..");
            List categories; 
            categories = bazaarAdmin.findByCategoryName("Dumpster");
            Iterator  i = categories.iterator();
            while (i.hasNext())
            {
              Category cat = (Category) i.next();
              System.out.println("Id:"+cat.getCategoryId()+" Name:"+cat.getCategoryName());
            }
            
            System.out.println("Finding categories By Viper Admin..");
            categories = bazaarAdmin.findByUser("viper");
            Iterator  j = categories.iterator();
            while (j.hasNext())
            {
              Category cat = (Category) j.next();
              System.out.println("Id:"+cat.getCategoryId()+" Name:"+cat.getCategoryName());
            }
            
            System.out.println("Finding Items by date..");
            Date currDate = new Date();
            List items = bazaarAdmin.getItemByDate(currDate);
            Iterator  k = items.iterator();
            while (k.hasNext())
            {
              Item item = (Item) k.next();
              System.out.println("Id:"+item.getItemId()+" Initial Price:"+item.getInitialPrice());
            }
 
            System.out.println("Finding Items by Price..");
            items = bazaarAdmin.getItemByPriceRange(100.0,145.0);
            Iterator  l = items.iterator();
            while (l.hasNext())
            {
              Item item = (Item) l.next();
              System.out.println("Id:"+item.getItemId()+" Initial Price:"+item.getInitialPrice());
            }
   
            System.out.println("Finding Users that have created items");
            List users = bazaarAdmin.getUserWithItems();
            Iterator  m = users.iterator();
            while (m.hasNext())
            {
              User user = (User) m.next();
              System.out.println("Id:"+user.getUserId()+" First Name:"+user.getFirstName());
            }

            System.out.println("Finding Users with items items");
            users = bazaarAdmin.getUserWithNoItems();
            Iterator  n = users.iterator();
            while (n.hasNext())
            {
              User user = (User) n.next();
              System.out.println("Id:"+user.getUserId()+" First Name:"+user.getFirstName());
            }

            System.out.println("Finding Users with more than items");
            users = bazaarAdmin.getUserWithItemsWithNativeQuery();
            Iterator  o = users.iterator();
            while (o.hasNext())
            {
              User user = (User) o.next();
              System.out.println("Id:"+user.getUserId()+" First Name:"+user.getFirstName());
            }

          
        }

   }
