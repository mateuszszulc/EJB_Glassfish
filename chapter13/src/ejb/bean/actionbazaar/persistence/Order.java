package actionbazaar.persistence;
import java.io.Serializable; 
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="ORDERS")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ORDER_ID")
    private Long orderId;

    @OneToOne(cascade=CascadeType.ALL) 
    @JoinColumn(name="ORDER_BIDDER_ID", referencedColumnName="USER_ID")                           
    private Bidder bidder;                                          
    
    @OneToMany(mappedBy="order", cascade=CascadeType.ALL)
    private List<Item> items;                                       
    
    @OneToOne(cascade=CascadeType.ALL)  
    @JoinColumn(name="ORDER_SHIPPING_ID", referencedColumnName="SHIPPING_ID")                           
    private ShippingInfo shippingInfo;                              
    
    @OneToOne(cascade=CascadeType.ALL)  
    @JoinColumn(name="ORDER_BILLING_ID", referencedColumnName="BILLING_ID")                           
    private BillingInfo billingInfo;

    @Column(name="ORDER_STATUS")
    @Enumerated(EnumType.STRING)    
    private OrderStatus status ;                                                            

    public Order() {
       
     }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    
    public Long getOrderId() {
        
        return this.orderId;
    }
    
    public BillingInfo getBillingInfo() {
        return this.billingInfo;
    }


    public Bidder getBidder() {
        return this.bidder;
    }
   
    public List<Item> getItems(){
        return this.items ;
    }


    public void setBidder(Bidder bidder) {
        this.bidder = bidder;
    }


    public void setItems(List<Item> items) {
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
