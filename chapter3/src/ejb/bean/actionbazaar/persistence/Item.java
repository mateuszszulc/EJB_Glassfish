package actionbazaar.persistence;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class Item implements Serializable {
    private String itemName;

    private Timestamp bidEndDate;

    private Timestamp bidStartDate;

    private Timestamp createdDate;

    private Double initialPrice;

    private Long itemId;

    private List<Bid> bids;


    public Item() {
    }


    public Item(Long itemId) {
        this.itemId = itemId;
    }


    public String getItemName() {
        return itemName;
    }


    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


    public Timestamp getBidEndDate() {
        return bidEndDate;
    }


    public void setBidEndDate(Timestamp bidEndDate) {
        this.bidEndDate = bidEndDate;
    }


    public Timestamp getBidStartDate() {
        return bidStartDate;
    }


    public void setBidStartDate(Timestamp bidStartDate) {
        this.bidStartDate = bidStartDate;
    }


    public Timestamp getCreatedDate() {
        return createdDate;
    }


    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }


    public Double getInitialPrice() {
        return initialPrice;
    }


    public void setInitialPrice(Double initialPrice) {
        this.initialPrice = initialPrice;
    }


    public Long getItemId() {
        return itemId;
    }


    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }


    public List<Bid> getBids() {
        return bids;
    }


    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }


    public Bid addBid(Bid bid) {
        getBids().add(bid);
        return bid;
    }


    public Bid removeBid(Bid bid) {
        getBids().remove(bid);
        return bid;
    }
}