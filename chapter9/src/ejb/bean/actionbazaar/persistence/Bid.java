package actionbazaar.persistence;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BIDS")
public class Bid implements Serializable {
    private Date bidDate;

    private Long bidId;

    private Double bidPrice;

    private Item item;

    private Bidder bidder;


    public Bid() {
    }


    public Bid(Bidder bidder, Item item, Double bidPrice) {
        this.item = item;
        this.bidder = bidder;
        this.bidPrice = bidPrice;
    }


    @SequenceGenerator(name = "BID_SEQ_GEN", sequenceName = "BID_SEQUENCE", initialValue = 1, allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BID_SEQ_GEN")
    @Column(name = "BID_ID")
    public Long getBidId() {
        return bidId;
    }


    @Column(name = "BID_DATE")
    public Date getBidDate() {
        return bidDate;
    }


    public void setBidDate(Date bidDate) {
        this.bidDate = bidDate;
    }


    public void setBidId(Long bidId) {
        this.bidId = bidId;
    }


    @Column(name = "BID_PRICE")
    public Double getBidPrice() {
        return bidPrice;
    }


    public void setBidPrice(Double bidPrice) {
        this.bidPrice = bidPrice;
    }


    @ManyToOne
    @JoinColumn(name = "BID_ITEM_ID", referencedColumnName = "ITEM_ID")
    public Item getItem() {
        return item;
    }


    public void setItem(Item item) {
        this.item = item;
    }


    @ManyToOne
    @JoinColumn(name = "BID_BIDDER", referencedColumnName = "USER_ID")
    public Bidder getBidder() {
        return bidder;
    }


    public void setBidder(Bidder bidder) {
        this.bidder = bidder;
    }
}