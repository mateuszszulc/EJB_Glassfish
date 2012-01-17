package actionbazaar.buslogic;


import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import actionbazaar.persistence.*;
import org.springframework.ejb.support.AbstractStatelessSessionBean;

@PersistenceContext(unitName="actionBazaar",name="actionBazaar")
@Stateless
public class PlaceBidBean extends AbstractStatelessSessionBean implements PlaceBid {	

 BidServiceBean bidService;

    protected void onEjbCreate() {
       bidService = (BidServiceBean)  getBeanFactory().getBean("bidService");
     }
		
 
    public PlaceBidBean() {
    }


    public Long addBid(String userId, Long itemId, Double bidPrice) {
                return bidService.addBid(userId, itemId, bidPrice);

        }

}
