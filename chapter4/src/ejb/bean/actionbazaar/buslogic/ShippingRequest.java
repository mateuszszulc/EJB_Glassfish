package actionbazaar.buslogic;

import java.io.Serializable;

public class ShippingRequest implements Serializable {

    protected long item;

    protected String shippingAddress;

    protected String shippingMethod;

    protected double insuranceAmount;


    public ShippingRequest() {
    }


    public long getItem() {
        return item;
    }


    public String getShippingMethod() {
        return shippingMethod;
    }


    public String getShippingAddress() {
        return shippingAddress;
    }


    public double getInsuranceAmount() {
        return insuranceAmount;
    }


    // setter methods

    public void setItem(long item) {
        this.item = item;
    }


    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }


    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }


    public void setInsuranceAmount(double insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }
}