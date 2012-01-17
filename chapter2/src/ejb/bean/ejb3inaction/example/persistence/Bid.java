package ejb3inaction.example.persistence;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BIDS")
public class Bid implements Serializable {
    private Date bidDate;

    private Long bidId;

    private Double bidPrice;

    private Long itemId;

    private String bidderId;


    public Bid() {
    }


    public Bid(String bidderId, Long itemId, Double bidPrice) {
        this.itemId = itemId;
        this.bidderId = bidderId;
        this.bidPrice = bidPrice;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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


    @Column(name = "BID_ITEM_ID")
    public Long getItemId() {
        return itemId;
    }


    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }


    @Column(name = "BID_BIDDER")
    public String getBidderId() {
        return bidderId;
    }


    public void setBidderId(String bidderId) {
        this.bidderId = bidderId;
    }
}
