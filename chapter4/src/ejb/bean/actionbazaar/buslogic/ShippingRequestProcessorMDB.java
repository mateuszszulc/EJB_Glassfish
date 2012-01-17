package actionbazaar.buslogic;

import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.sql.DataSource;

@MessageDriven(name = "ShippingRequestProcessor", activationConfig = {                                           
        @ActivationConfigProperty(                                  
            propertyName="destinationType",                         
            propertyValue="javax.jms.Queue"),                       
        @ActivationConfigProperty(                                  
            propertyName="destinationName",                         
            propertyValue="ShippingRequestQueue")
     
    }   
   ,mappedName = "ShippingRequestQueue"                                                                               
)      
public class ShippingRequestProcessorMDB implements MessageListener {
    private java.sql.Connection connection;

    private DataSource dataSource;

    @Resource
    private MessageDrivenContext context;


    @Resource(name = "jdbc/TurtleDS")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @PostConstruct
    public void initialize() {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
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


    public void onMessage(Message message) {
        try {
            ObjectMessage objectMessage = (ObjectMessage) message;
            ShippingRequest shippingRequest = (ShippingRequest) objectMessage
                    .getObject();
            processShippingRequest(shippingRequest);
        } catch (JMSException jmse) {
            jmse.printStackTrace();
            context.setRollbackOnly();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            context.setRollbackOnly();
        }
    }


    private void processShippingRequest(ShippingRequest request)
            throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO " + "SHIPPING_REQUESTS (" + "ITEM_ID, "
                + "SHIPPING_ADDRESS, " + "SHIPPING_METHOD, "
                + "INSURANCE_AMOUNT ) " + "VALUES ( " + request.getItem()
                + ", " + "\'" + request.getShippingAddress() + "\', " + "\' "
                + request.getShippingMethod() + "\', "
                + request.getInsuranceAmount() + " )";
        System.out.println("Shipping Request processed..");
        statement.execute(sql);
    }
}