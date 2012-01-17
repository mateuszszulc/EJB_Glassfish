package actionbazaar.persistence;

import java.util.Set;

public class Bidder extends User {
    private Long creditRating;

    private Set<Bid> bids;


    public Bidder() {
    }


    public Long getCreditRating() {
        return creditRating;
    }


    public void setCreditRating(Long creditRating) {
        this.creditRating = creditRating;
    }


    public Set<Bid> getBids() {
        return bids;
    }


    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }
}