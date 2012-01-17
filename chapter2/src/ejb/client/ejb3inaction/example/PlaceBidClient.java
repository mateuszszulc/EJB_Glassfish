package ejb3inaction.example.buslogic;
import javax.ejb.EJB;
import ejb3inaction.example.persistence.Bid;


public class PlaceBidClient {
     @EJB
        private static PlaceBid placeBid;
    public static void main(String [] args) {
        try {
             Bid bid = new Bid();
             bid.setBidderId("npanda");
             bid.setItemId(Long.valueOf(100));
             bid.setBidPrice(20000.40);

            System.out.println("Bid Successful, BidId Received is:" +placeBid.addBid(bid).getBidId());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

   }
