package ie.ait.msc.discount.store.dto;

import java.io.Serializable;

public class RetailerDto implements Serializable {

    private static final long serialVersionUID = -714705456692907944L;

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
