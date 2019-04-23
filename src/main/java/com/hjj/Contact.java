package com.hjj;

/**
 * @Auther: HJJ
 * @Date: 2019/04/22 15:50
 * @Description:
 */
public class Contact {
    private String address;
    private String telphone;

    public Contact() {
    }

    public Contact(String address, String telphone) {
        this.address = address;
        this.telphone = telphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }
}
