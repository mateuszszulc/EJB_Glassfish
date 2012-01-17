package actionbazaar.persistence;

import java.io.Serializable;

public class BiographicalInfo implements Serializable {

    protected String firstName;

    protected String lastName;


    public BiographicalInfo() {
    }


    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}