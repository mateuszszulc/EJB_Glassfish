package actionbazaar.persistence;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue(value="S")
public class Seller extends User{
    private Double commissionRate;
    private Long maxItemsAllowed;
    private Set<Item> items;
    
    public Seller() {
    }

    @Column(name="COMM_RATE")
    public Double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Double commissionRate) {
        this.commissionRate = commissionRate;
    }

    @Column(name="MAX_ITEMS")
    public Long getMaxItemsAllowed() {
        return maxItemsAllowed;
    }

    public void setMaxItemsAllowed(Long maxItemsAllowed) {
        this.maxItemsAllowed = maxItemsAllowed;
    }
   
    @OneToMany(mappedBy="seller")
    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public Item addItem(Item item) {
        getItems().add(item);
        item.setSeller(this);
        return item;
    }

    public Item removeItem(Item item) {
        getItems().remove(item);
        item.setSeller(null);
        return item;
    }    


    }
