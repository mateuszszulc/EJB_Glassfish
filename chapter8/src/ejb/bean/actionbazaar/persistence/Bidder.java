package actionbazaar.persistence;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "B")
public class Bidder extends User {
    private BidderStatus bidderStatus;

    private Long creditRating;

    private Set<Bid> bids;


    public Bidder() {
    }


    @Column(name = "BIDDER_STATUS")
    @Enumerated(EnumType.STRING)
    public BidderStatus getBidderStatus() {
        return bidderStatus;
    }


    public void setBidderStatus(BidderStatus bidderStatus) {
        this.bidderStatus = bidderStatus;
    }


    @Column(name = "CREDIT_RATING")
    public Long getCreditRating() {
        return creditRating;
    }


    public void setCreditRating(Long creditRating) {
        this.creditRating = creditRating;
    }


    @OneToMany(mappedBy = "bidder")
    public Set<Bid> getBids() {
        return bids;
    }


    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }
}