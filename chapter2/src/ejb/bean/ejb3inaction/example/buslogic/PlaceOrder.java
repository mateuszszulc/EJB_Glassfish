package ejb3inaction.example.buslogic;

import javax.ejb.Remote;

@Remote
public interface PlaceOrder {
    void setBidderId(Long bidderId);


    void addItem(Long itemId);


    void setShippingInfo(ShippingInfo shippingInfo);


    void setBillingInfo(BillingInfo billingInfo);


    Long confirmOrder();
}
