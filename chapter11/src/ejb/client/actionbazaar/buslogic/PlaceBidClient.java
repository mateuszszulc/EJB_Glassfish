package actionbazaar.buslogic;
import actionbazaar.persistence.*;
import javax.ejb.EJB;

public class PlaceBidClient {
     @EJB
        private static PlaceBid placeBid;
    public static void main(String [] args) {
        try {
            Bid bid = placeBid.addBid("idiot",  Long.valueOf(100),  2000.50);
            System.out.println("Bid Successful, BidId Received is:" +bid.getBidId());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

   }
