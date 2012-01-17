package ejb3inaction.example.buslogic;

import java.io.Serializable;

public class LoginInfo implements Serializable {

    protected String username;

    protected String password;


    public LoginInfo() {
    }


    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }


    public void setUsername(String userName) {
        this.username = userName;
    }


    public void setPassword(String password) {
        this.password = password;
    }
}
