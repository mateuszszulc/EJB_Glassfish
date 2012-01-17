package actionbazaar.buslogic;

import javax.ejb.EJB;

public class PlaceBidClient {
    @EJB
    private static PlaceBid placeBid;


    public static void main(String[] args) {
        try {
            System.out.println("Bid Price Sent to the bean is:" + 20000.5);
            System.out.println("Bid Successful, BidId Received is:"
                    + placeBid.addBid("dpanda", Long.valueOf(403), 20000.50));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}