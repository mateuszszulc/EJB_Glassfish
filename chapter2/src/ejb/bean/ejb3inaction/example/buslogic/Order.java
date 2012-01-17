package ejb3inaction.example.buslogic;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {
    private Long orderId;

    private Long bidderId;

    private List<Long> items;

    private ShippingInfo shippingInfo;

    private BillingInfo billingInfo;

    private OrderStatus status;


    public Order() {}


    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }


    public Long getOrderId() {
        // implement code to generate an orderId
        return new Long(1000);
    }


    public BillingInfo getBillingInfo() {
        return this.billingInfo;
    }


    public void setBidderId(Long bidderId) {
        this.bidderId = bidderId;
    }


    public void setItems(List<Long> items) {
        this.items = items;
    }


    public void setShippingInfo(ShippingInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
    }


    public void setStatus(OrderStatus orderStatus) {
        this.status = orderStatus;
    }


    public void setBillingInfo(BillingInfo billingInfo) {
        this.billingInfo = billingInfo;
    }
}
