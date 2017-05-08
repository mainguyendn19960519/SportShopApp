package com.example.mainguyen.sportshopapp.Models;

/**
 * Created by mai.nguyen on 11/04/2017.
 */

public class Staffs {

    private int staffId;
    private String name;
    private String address;
    private String phone;
    private String identityCard;
    private String username;
    private String password;
    private int roleId;
    private String message;

    public Staffs(){

    }

    public Staffs(int staffId, String name, String address, String phone,
                  String identityCard, String username, int roleId, String message) {
        this.staffId = staffId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.identityCard = identityCard;
        this.username = username;
        this.roleId = roleId;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }


}
