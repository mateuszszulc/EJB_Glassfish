package actionbazaar.persistence;

import java.io.*;
import javax.persistence.*;

@Entity
@Table(name = "BILLING_DETAILS")
public class BillingInfo implements Serializable {

  protected String accountNumber;
  protected String accountType;
  protected String expiryDate;
  protected Long id;

  public BillingInfo() {}

  

public BillingInfo(String accountNumber, String expiryDate, String accountType) {
    this.accountNumber = accountNumber;
    this.expiryDate = expiryDate;
    this.accountType = accountType;
    return;
  }

  // getter methods


@SequenceGenerator(name="BILLING_SEQ_GEN", sequenceName="BILLING_SEQ",initialValue=1,allocationSize=1)
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="BILLING_SEQ_GEN")
 @Column(name="BILLING_ID")
  public Long getId()
  {
    return id;
   }



  @Column(name="ACCOUNT_NO")
  public String getAccountNumber() {
    return accountNumber;
  }

  @Column(name="EXPIRY_DATE") 
  public String getExpiryDate() {
    return expiryDate;
  }
  
  @Column(name="ACCOUNT_TYPE")
  public String getAccountType() {
    return accountType;
  }

  // setter methods

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public void setExpiryDate(String expiryDate) {
    this.expiryDate = expiryDate;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

 public void setId(Long id) {
    this.id = id;
    return;
  }
}


