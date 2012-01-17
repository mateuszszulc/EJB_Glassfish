package actionbazaar.persistence;
import javax.persistence.*;

import java.io.*;

@Entity
@Table(name="SHIPPING_INFO")
public class ShippingInfo implements Serializable {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="SHIPPING_ID")
  private Long id;
  
  protected String street;
  protected String city;
  protected String state;


  public ShippingInfo(){}
  
  public ShippingInfo(String street, String city, String state ) {
    this.street = street;
    this.city = city;
    this.state = state; 
  }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        
        return this.id;
    }
    
  public String getStreet() {
    return street;
  }

  public String getState() {
    return state;
  }
  
  public String getCity() {
    return city;
  }


  public void setStreet(String street) {
    this.street = street;
  }

  public void setState(String state) {
    this.state = state;
  }

  public void setCity(String city) {
    this.city = city;
  }

}


