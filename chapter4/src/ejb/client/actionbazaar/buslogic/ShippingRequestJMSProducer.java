package actionbazaar.buslogic;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

public class ShippingRequestJMSProducer {
    @Resource(name = "jms/ShippingRequestQueue", mappedName = "ShippingRequestQueue")
    private static Destination destination;

    @Resource(name = "jms/QueueConnectionFactory")
    private static ConnectionFactory connectionFactory;


    public static void main(String[] args) {
        long item = 10101;
        String address = "101 In Hell ";
        String method = "snailMail";
        double amount = 101.00;

        try {
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false,
                    Session.AUTO_ACKNOWLEDGE);

            MessageProducer producer = session.createProducer(destination);

            ObjectMessage message = session.createObjectMessage();
            ShippingRequest shippingRequest = new ShippingRequest();
            shippingRequest.setItem(item);
            shippingRequest.setShippingAddress(address);
            shippingRequest.setShippingMethod(method);
            shippingRequest.setInsuranceAmount(amount);
            message.setObject(shippingRequest);
            producer.send(message);
            session.close();
            connection.close();
            System.out.println("Shipping Request Message Sent ..");

        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}