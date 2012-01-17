package actionbazaar.buslogic;
import javax.xml.ws.WebServiceRef ;
import actionbazaarplacebidservice.PlaceBidService;

public class PlaceBidClient {

// Modify wsdlLocation for your environment

@WebServiceRef(wsdlLocation="http://localhost:3734/PlaceBidService/PlaceBidBean?WSDL") 
  private static PlaceBidService placeBidService;

    public static void main(String [] args) {
        try {
            actionbazaarplacebidservice.PlaceBidBean placeBid = placeBidService.getPlaceBidBeanPort();	 
            System.out.println("Bid Price Sent to the bean is:"+200000.5);
            System.out.println("Bid Successful, BidId Received is:" +placeBid.addBid("idiot",  Long.valueOf(1),  2000005.50 ));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

   }
