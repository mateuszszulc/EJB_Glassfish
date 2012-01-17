
package actionbazaar.persistence;
import javax.persistence.*;

@Entity
@Table(name="BILLING_DETAILS")
public class BillingInfo implements java.io.Serializable {

    
    protected long billingId;
    protected String accountNumber;
    protected String expiryDate;
    protected String secretCode;
    protected Address address;

        
    public BillingInfo() {
    }

    @SequenceGenerator(name="BILLING_SEQ_GEN", 
    sequenceName="BILLING_SEQUENCE", 
                         initialValue=1, allocationSize=1)
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="BILLING_SEQ_GEN")
    @Column(name="BILLING_ID")
    public Long getBillingId(){
        return this.billingId;
    }
    
    
    @Column(name="ACCOUNT_NO")
    public String getAccountNumber(){
        return accountNumber;
    }
    
    
    @Column(name="EXPIRY_DATE")
    public String getExpiryDate(){
        return expiryDate;
    }
    
    @Column(name="SECRET_CODE")
     public String getSecretCode(){
        return secretCode;
    }
    
    @Embedded
    @AttributeOverrides(
       {@AttributeOverride(name="state",column=@Column(name="STATE_CD")),
    	  @AttributeOverride(name="zipCode",column=@Column(name="ZIP_CD"))
        })

     public Address getAddress(){
        return address;
    }
    
    
    
    public void setBillingId(Long billingId){
        this.billingId = billingId;
    }


    public void setAccountNumber(String accountNumber ){
        this.accountNumber=accountNumber;
    }
    
    
    public void setExpiryDate(String expiryDate){
        this.expiryDate= expiryDate;
    }
    
     
    public void setSecretCode(String secretCode){
           this.secretCode= secretCode;
    }
   public void setAddress(Address address){
           this.address= address;
    }


}
