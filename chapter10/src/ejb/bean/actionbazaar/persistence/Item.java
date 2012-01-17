package actionbazaar.persistence;

import java.io.Serializable;

import java.sql.Timestamp;
import javax.persistence.*;
import java.util.Set;

@Entity
@EntityListeners({actionbazaar.persistence.ItemVerifier.class})
@NamedQueries({
@NamedQuery(
name="findItemByDate",
query="SELECT i FROM Item AS i WHERE i.bidEndDate > :currentDate"
),
@NamedQuery(
name="findItemByInitialPrice",
query="SELECT i FROM Item AS i WHERE i.initialPrice between :lowPrice and :highPrice"
)
})
@Table(name="ITEMS")
public class Item implements Serializable {
    private String itemName;
    private Timestamp bidEndDate;
    private Timestamp bidStartDate;
    private Timestamp createdDate;
    private Double initialPrice;
    private Long itemId;
    private Set<Category> category;
    private User user;
    public Item() {
    }

    
    public Item(Long itemId) {
        this.itemId = itemId;
    }
    
    @TableGenerator(name="ITEM_TABLE_GEN",
		 table="TABLE_SEQ_GEN",
		 pkColumnName="SEQ_NAME",
		 valueColumnName="SEQ_COUNT",
		 pkColumnValue="ITEM_SEQ")


    @Column(name="ITEM_NAME")
    //@Basic(fetch=FetchType.LAZY)
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    @Column(name="BID_END_DATE")
    public Timestamp getBidEndDate() {
        return bidEndDate;
    }

    public void setBidEndDate(Timestamp bidEndDate) {
        this.bidEndDate = bidEndDate;
    }

    @Column(name="BID_START_DATE")
    public Timestamp getBidStartDate() {
        return bidStartDate;
    }

    public void setBidStartDate(Timestamp bidStartDate) {
        this.bidStartDate = bidStartDate;
    }


    @Column(name="CREATED_DATE")
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name="INITIAL_PRICE")
    public Double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(Double initialPrice) {
        this.initialPrice = initialPrice;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ITEM_ID", nullable=false)
    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }


    @ManyToMany(mappedBy="items")    
    public Set<Category> getCategory() {
        return category;
    }

    public void setCategory(Set<Category> category) {
        this.category = category;
    }
    
    public Category addCategory(Category category) {
        getCategory().add(category);
        //category.addItem(this);
        return category;
    }

    public Category removeCategory(Category category) {
        getCategory().remove(category);
        //category.setCategory(null);
        return category;
    }


    @ManyToOne(cascade=CascadeType.REMOVE)
    @JoinColumn(name="SELLER_ID", referencedColumnName="USER_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
