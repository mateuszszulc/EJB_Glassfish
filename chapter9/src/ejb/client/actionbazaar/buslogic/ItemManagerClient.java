package actionbazaar.buslogic;

import javax.ejb.EJB;

import actionbazaar.persistence.Item;

public class ItemManagerClient {
    @EJB
    private static ItemManager itemManager;


    public static void main(String[] args) {

        Item item = itemManager.addItem("Vintage Car from Junk Yard",
                "description goes here", new Double(120.00), "idiot");

        System.out.println("Item created with Item Id:" + item.getItemId());
        item.setTitle("New Title: Cars those met accident");
        itemManager.updateItem(item);
        System.out.println("Title for item Id " + item.getItemId()
                + " updated successfully");
    }
}