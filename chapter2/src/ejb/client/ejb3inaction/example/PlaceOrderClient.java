package ejb3inaction.example.buslogic;

import javax.ejb.EJB;

public class PlaceOrderClient {
    @EJB
        private static PlaceOrder placeOrder;
    public static void main(String [] args) {
           
        System.out.println("Exercising PlaceOrder EJB...");
        placeOrder.setBidderId(new Long(100));
        placeOrder.addItem(new Long(200));
        placeOrder.addItem(new Long(201));
        placeOrder.setShippingInfo(new ShippingInfo("123 My Sweet Home","MyCity","MyState"));
        placeOrder.setBillingInfo(new BillingInfo("123456789","VISA","0708"));
        Long orderId = placeOrder.confirmOrder();
         System.out.println("Order confirmation number: " + orderId);
            
         }

  }
