package com.os.operando.emptyactivity;

/**
 * Created by AdrenResi on 11/15/2017.
 */

public class Contact {
    public Contact(int image_id, String address, String phone, String hours) {
        this.setImage_id(image_id);
        this.setAddress(address);
        this.setPhone(phone);
        this.setHours(hours);
    }

    private int image_id;
    private String address, phone, hours;

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

}
