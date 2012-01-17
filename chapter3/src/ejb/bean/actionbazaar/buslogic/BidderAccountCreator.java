package actionbazaar.buslogic;

import javax.ejb.Remote;
import actionbazaar.persistence.*;

@Remote
public interface BidderAccountCreator {
    void addLoginInfo(LoginInfo loginInfo);


    void addBiographicalInfo(BiographicalInfo biographicalInfo)
            throws WorkflowOrderViolationException;


    void addBillingInfo(BillingInfo billingInfo)
            throws WorkflowOrderViolationException;


    void cancelAccountCreation();


    void createAccount();
}