package ejb3inaction.example.buslogic;

import java.io.Serializable;

public class ShippingInfo implements Serializable {

    protected String street;

    protected String city;

    protected String state;


    public ShippingInfo() {
    }


    public ShippingInfo(String street, String city, String state) {
        this.street = street;
        this.city = city;
        this.state = state;
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
