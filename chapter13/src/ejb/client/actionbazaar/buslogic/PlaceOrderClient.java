package actionbazaar.buslogic;

import javax.ejb.EJB;
import actionbazaar.persistence.*;

public class PlaceOrderClient {
    @EJB
        private static PlaceOrder placeOrder;
    public static void main(String [] args) {
           
        System.out.println("Exercising PlaceOrder EJB...");
        placeOrder.setBidder("idiot2");
        placeOrder.addItem(new Long(1));
        placeOrder.addItem(new Long(2));
        placeOrder.setShippingInfo(new ShippingInfo("123 My Sweet Home","MyCity","MyState"));
        placeOrder.setBillingInfo(new BillingInfo("123456789","VISA","0708"));
        Long orderId = placeOrder.confirmOrder();
        System.out.println("Order confirmation number: " + orderId);
            
        }

  }
