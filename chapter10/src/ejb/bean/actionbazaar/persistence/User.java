package actionbazaar.persistence;

import java.io.Serializable;

import java.util.Set;
import java.util.Date;


import javax.persistence.*;
import javax.persistence.DiscriminatorType.*;
import javax.persistence.CascadeType.*;
import javax.persistence.InheritanceType.*;



@Entity
@NamedQueries({
@NamedQuery(
name="findUserWithItems",
query="SELECT distinct u FROM User u WHERE  exists (SELECT i FROM Item i WHERE i=u.items)"),
@NamedQuery(
name="findUserWithNoItems",
query="SELECT distinct u FROM User u WHERE  u.items is EMPTY"
)
})
@NamedNativeQuery(
name="findUserWithMoreItems",
query="select user_id , first_name , last_name, birth_date from users where user_id in (select seller_id from items group by seller_id having count(*) >?1)",
resultClass=actionbazaar.persistence.User.class
)
@Table(name="USERS")
//@SecondaryTable(name="USER_PICTURES", pkJoinColumns=@PrimaryKeyJoinColumn(name="USER_ID")) 
//@Inheritance(strategy=InheritanceType.JOINED)
//@DiscriminatorColumn(name="USER_TYPE",discriminatorType=CHAR, length=1)
public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String userId;
   // private byte[] picture;
    private Date  birthDate;

    private Set<Category> categories;
    private Set<Item> items;
    private BillingInfo billingInfo;

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
    @Lob @Basic(fetch=FetchType.EAGER)
    public byte[] getPicture() {
        return picture;
    }
    
    public void setPicture(byte[] picture) {
        this.picture = picture;
    }*/
    @Column(name="BIRTH_DATE", nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE) 
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate (Date birthDate) {
        this.birthDate = birthDate;
    }



    @OneToMany(mappedBy="user",cascade=CascadeType.ALL)
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

    @OneToMany(mappedBy="user",cascade=CascadeType.ALL)
    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="USER_BILLING_ID", referencedColumnName="BILLING_ID")
    public BillingInfo getBillingInfo() {
        return billingInfo;
    }

    public void setBillingInfo(BillingInfo billingInfo) {
        this.billingInfo = billingInfo;
    }

    public Item addItem(Item item) {
        getItems().add(item);
        item.setUser(this);
        return item;
    }

    public Item removeItem(Item item) {
        getItems().remove(item);
        item.setUser(null);
        return item;
    }
   

}
