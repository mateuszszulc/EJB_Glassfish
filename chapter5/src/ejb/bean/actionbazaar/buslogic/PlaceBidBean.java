package actionbazaar.buslogic;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.interceptor.Interceptors;
import javax.sql.DataSource;

@Interceptors( { actionbazaar.buslogic.ActionBazaarProfilingInterceptor.class })
@Stateless
public class PlaceBidBean implements PlaceBid {
    private DataSource ds;

    private Connection con;

    @Resource
    private SessionContext sc;


    @Resource(name = "jdbc/ActionBazaarDS")
    public void setDs(DataSource ds) {
        this.ds = ds;
    }


    public DataSource getDs() {
        return this.ds;
    }


    @PostConstruct
    public void initialize() {
        try {
            con = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Interceptors(actionbazaar.buslogic.DiscountVerifierInterceptor.class)
    public Long addBid(String userId, Long itemId, Double bidPrice) {
        System.out.println("Bid for " + itemId + " received with price"
                + bidPrice);
        Long bidId = getBidId();
        createBid(userId, itemId, bidPrice, bidId);
        return bidId;
    }


    private void createBid(String userId, Long itemId, Double bidPrice,
            Long bidId) {
        try {

            Statement stmt = con.createStatement();
            stmt
                    .execute("INSERT INTO BIDS(BID_ID,BID_BIDDER,BID_ITEM_ID,BID_PRICE) VALUES("
                            + getBidId()
                            + ",\'"
                            + userId
                            + "\',"
                            + itemId
                            + "," + bidPrice + ")");
            TimerService ts = sc.getTimerService();
            // Created a single event timer that expires after half hour
            Timer timer = ts.createTimer(1800000, bidId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private Long getBidId() {
        // Add Code for generating a unique key
        Long bidId = Long.valueOf(1002);
        return bidId;
    }


    @PreDestroy
    public void cleanup() {
        try {
            con.close();
            con = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Timeout
    public void sendBidInfo(Timer timer) {
        System.out.println("BidManager EJB: Monitor status of BidId:"
                + timer.getInfo());
        // Implement Your Business Logic Here to monitor the status for bidId
        // and send email to the bidder
        return;
    }
}
