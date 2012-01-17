package actionbazaar.buslogic;
import javax.naming.Context;
import javax.naming.InitialContext;
import actionbazaar.persistence.*;
import javax.ejb.EJB;


public class ItemManagerClient {
@EJB
private static ItemManager itemManager;
    public static void main(String [] args) {
                                       
            Item item = itemManager.addItem("Vintage Car from Junk Yard",
                                        "description goes here", new Double(120.00),"idiot");

            System.out.println("Item created with Item Id:"+item.getItemId());
            item.setTitle("New Title: Cars those met accident");
            itemManager.updateItem(item);                         
            }

   }
