package actionbazaar.persistence;

import java.io.Serializable;

import java.util.Set;
import java.util.Date;


import javax.persistence.*;
//@SecondaryTable(name="USER_PICTURES", pkJoinColumns=@PrimaryKeyJoinColumn(name="USER_ID")) 


@Entity
@Table(name="USERS")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="USER_TYPE",discriminatorType=DiscriminatorType.STRING, length=1)
public  class  User implements Serializable {
    private String firstName;
    private String lastName;
    private String userId;
    private byte[] picture;
    private Date  birthDate;
    private BillingInfo billingInfo;
    private ContactInfo contactInfo;

    private Set<Category> categories;
    public User() {
    }

    public User(String firstName, String lastName, String userId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
        }
    
    @Column(name="FIRST_NAME", nullable=false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName.toUpperCase();
    }

    @Column(name="LAST_NAME", nullable=false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Id
    @Column(name="USER_ID", nullable=false)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    /*@Column(name="PICTURE", table="USER_PICTURES")
    @Lob 
    @Basic(fetch=FetchType.LAZY)
    public byte[] getPicture() {
        return picture;
    }
    
    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
   */
    @Column(name="BIRTH_DATE", nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE) 
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate (Date birthDate) {
        this.birthDate = birthDate;
    }


    @OneToOne(cascade=CascadeType.ALL)  
    @PrimaryKeyJoinColumn(name="USER_ID",referencedColumnName="CONTACT_USER_ID")                           
    public ContactInfo getContactInfo() {
        return contactInfo;
    }
    
    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }


    @OneToOne(cascade=CascadeType.ALL)  
    @JoinColumn(name="USER_BILLING_ID", referencedColumnName="BILLING_ID")                           
    public BillingInfo getBillingInfo() {
        return billingInfo;
    }


    public void setBillingInfo(BillingInfo billingInfo) {
        this.billingInfo = billingInfo;
    }


    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    public Set<Category> getcategories() {
        return categories;
    }

    public void setcategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Category addCategory(Category category) {
        getcategories().add(category);
        category.setUser(this);
        return category;
    }

    public Category removeCategory(Category category) {
        getcategories().remove(category);
        category.setUser(null);
        return category;
    }

    
}
