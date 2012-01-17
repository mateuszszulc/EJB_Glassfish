package actionbazaar.buslogic;

import javax.ejb.EJB;

import actionbazaar.persistence.Bidder;

public class BazaarAdminClient {
    @EJB
    private static BazaarAdmin bazaarAdmin;


    public static void main(String[] args) {

        Bidder bidder = new Bidder();
        bidder.setUserId("idiot2");
        bidder.setFirstName("Serious");
        bidder.setLastName("Bidder");
        bidder.setCreditRating(new Long(65));
        bidder = bazaarAdmin.createBidder(bidder);
        System.out.println("Bidder :" + bidder.getUserId() + " BidderStatus:"
                + bidder.getBidderStatus());
    }
}