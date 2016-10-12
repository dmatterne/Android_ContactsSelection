package be.david.contactsselection;

import java.io.Serializable;

/**
 * Created by David on 12/10/2016.
 */

public class Contact implements Serializable{

    private String name;

    private String phone;

    private String website;

    public Contact(String name, String phone, String website) {

        super();
        this.name = name;
        this.phone = phone;
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
