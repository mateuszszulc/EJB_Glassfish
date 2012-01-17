package actionbazaar.buslogic;
import actionbazaar.persistence.*;

import javax.ejb.EJB;

public class AccountCreatorClient {
    @EJB
    private static BidderAccountCreator accountCreator;


    public static void main(String[] args) {

        LoginInfo login = new LoginInfo();
        login.setUsername("dpanda");
        login.setPassword("welcome");

        accountCreator.addLoginInfo(login);

        BiographicalInfo bio = new BiographicalInfo();
        bio.setFirstName("Debu");
        bio.setLastName("Panda");

        accountCreator.addBiographicalInfo(bio);

        BillingInfo billing = new BillingInfo();
        billing.setCreditCardType("VISA");
        billing.setAccountNumber("0123456789");

        accountCreator.addBillingInfo(billing);

        // Create account
        accountCreator.createAccount();
    }
}