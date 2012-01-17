package actionbazaar.buslogic;
import javax.ejb.Remote;
import actionbazaar.persistence.*;

@Remote                                                             
public interface PlaceOrder {
    void setBidder(String bidderId);
    void addItem(Long itemId);
    void setShippingInfo(ShippingInfo shippingInfo);
    void setBillingInfo(BillingInfo billingInfo);
    Long confirmOrder();
}
