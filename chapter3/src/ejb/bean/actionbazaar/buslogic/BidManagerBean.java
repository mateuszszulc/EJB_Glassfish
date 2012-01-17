package actionbazaar.buslogic;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import actionbazaar.persistence.Bid;
import actionbazaar.persistence.Item;

@Stateless(name = "BidManager")
public class BidManagerBean implements BidManager {

    private Connection connection;

    @Resource
    private SessionContext sc;

    @Resource(name = "jdbc/ActionBazaarDS")
    private DataSource dataSource;


    @PostConstruct
    public void initialize() {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    }


    public Long addBid(Bid bid) {

        Long bidId = getBidId();
        try {

            Statement statement = connection.createStatement();
            statement
                    .execute("INSERT INTO BIDS(BID_ID,BID_BIDDER,BID_ITEM_ID,BID_PRICE) VALUES("
                            + bidId
                            + ",\'"
                            + bid.getBidder().getUserId()
                            + "\',"
                            + bid.getItem().getItemId()
                            + ","
                            + bid.getBidPrice() + ")");
        } catch (Exception sqle) {
            sqle.printStackTrace();
        }
        return bidId;
    }


    private Long getBidId() {
        // Add Code for generating a unique key
        return Long.valueOf(1002);
    }


    public void cancelBid(Bid bid) {
    }


    public List<Bid> getBids(Item item) {
        return item.getBids();
    }


    @PreDestroy
    public void cleanup() {
        try {
            connection.close();
            connection = null;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}