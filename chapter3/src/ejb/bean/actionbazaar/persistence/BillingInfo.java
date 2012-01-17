package actionbazaar.persistence;

import java.io.Serializable;

public class BillingInfo implements Serializable {

    protected String accountNumber;

    protected String creditCardType;

    protected String expiryDate;


    public BillingInfo() {
    }


    public String getAccountNumber() {
        return accountNumber;
    }


    public String getExpiryDate() {
        return expiryDate;
    }


    public String getCreditCardType() {
        return creditCardType;
    }


    // setter methods

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }


    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }


    public void setCreditCardType(String creditCardType) {
        this.creditCardType = creditCardType;
    }
}