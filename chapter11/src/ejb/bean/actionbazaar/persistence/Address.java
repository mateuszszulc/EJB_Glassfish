
package actionbazaar.persistence;
import javax.persistence.*;

@Embeddable
public class Address implements java.io.Serializable {
  

  protected String streetName1;
  protected String streetName2;
  protected String city;
  protected String state;
  protected String zipCode;
  protected String country;


  public Address() {}

  public Address(String streetName1, String streetName2, String city,
                 String state, String zipCode, String country) {
    this.streetName1 = streetName1;
    this.streetName2 = streetName2;
    this.city = city;
    this.state = state;
    this.zipCode = zipCode;
    this.country = country;
  }

  
  public String getStreetName1() {
    return streetName1;
  }

 
  public String getStreetName2() {
    return streetName2;
  }

  public String getCity() {
    return city;
  }

  @Column(name="STATE_CODE")
  public String getState() {
    return state;
  }

  public String getCountry() {
    return country;
  }

  @Column(name="ZIP_CODE")
  public String getZipCode() {
    return zipCode;
  }

  public  void setStreetName1(String  streetName1) {
    this.streetName1 =streetName1;
  }

   public  void setStreetName2(String  streetName2) {
    this.streetName1 =streetName2;
  }


  public  void setCity(String city) {
    this.city=city;
  }

  public void setState(String state) {
    this.state= state;
  }

  public void setCountry(String  country) {
    this.country=country;
  }

  public void setZipCode(String zipCode ) {
    this.zipCode = zipCode;
  }
}


