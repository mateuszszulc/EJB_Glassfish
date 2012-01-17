package actionbazaar.persistence;

import java.io.Serializable;
import java.sql.Date;

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


    public Long getBidId() {
        return bidId;
    }


    public Date getBidDate() {
        return bidDate;
    }


    public void setBidDate(Date bidDate) {
        this.bidDate = bidDate;
    }


    public void setBidId(Long bidId) {
        this.bidId = bidId;
    }


    public Double getBidPrice() {
        return bidPrice;
    }


    public void setBidPrice(Double bidPrice) {
        this.bidPrice = bidPrice;
    }


    public Item getItem() {
        return item;
    }


    public void setItem(Item item) {
        this.item = item;
    }


    public Bidder getBidder() {
        return bidder;
    }


    public void setBidder(Bidder bidder) {
        this.bidder = bidder;
    }
}