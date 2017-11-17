package com.os.operando.emptyactivity;

import java.util.ArrayList;

/**
 * Created by AdrenResi on 11/15/2017.
 */

// PLEASE READ: I was basically following a YouTube tutorial to the tee. This is actually for the Store List.

public class Contact {
    public Contact(int image_id, String address, String phone, String hours, ArrayList<String> passStrings) {
        this.setImage_id(image_id);
        this.setAddress(address);
        this.setPhone(phone);
        this.setHours(hours);
        this.setPassStrings(passStrings);
    }

    private int image_id;
    private String address, phone, hours;
    // new PassStrings code
    ArrayList<String> passStrings;

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // new PassStrings code
    public ArrayList<String> getPassStrings() { return passStrings; }

    // new PassStrings code
    public void setPassStrings(ArrayList<String> passStrings) {
        this.passStrings = passStrings;
    }

}
