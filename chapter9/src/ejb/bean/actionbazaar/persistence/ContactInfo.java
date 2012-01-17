package actionbazaar.persistence;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACT_DETAILS")
public class ContactInfo implements java.io.Serializable {

    protected String userId;

    protected String telephone;

    protected String email;

    protected Address address;


    public ContactInfo() {
    }


    @Id
    @Column(name = "CONTACT_USER_ID")
    public String getUserId() {
        return this.userId;
    }


    public String getEMail() {
        return email;
    }


    @Column(name = "PHONE")
    public String getTelephone() {
        return telephone;
    }


    @Embedded
    public Address getAddress() {
        return address;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }


    public void setEMail(String email) {
        this.email = email;
    }


    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public void setAddress(Address address) {
        this.address = address;
    }
}