package actionbazaar.persistence;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String firstName;

    private String lastName;

    private String userId;

    private byte[] picture;

    private Date birthDate;


    public User() {
    }


    public User(String firstName, String lastName, String userId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName.toUpperCase();
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getUserId() {
        return userId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }


    public Date getBirthDate() {
        return birthDate;
    }


    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}