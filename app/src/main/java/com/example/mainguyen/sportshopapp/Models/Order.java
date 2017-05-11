package com.example.mainguyen.sportshopapp.Models;

/**
 * Created by nhan.ly on 5/5/2017.
 */

public class Order {
    private int staff_id;
    private int orderId;
    private boolean status;
    private String orderDate;
    private Double total;
    private String customer_name;
    private String address;
    private String phone;

    public Order() {
    }

    public Order(int staff_id, int orderId, boolean status, String orderDate, Double total, String customer_name, String address, String phone) {
        this.staff_id = staff_id;
        this.orderId = orderId;
        this.status = status;
        this.orderDate = orderDate;
        this.total = total;
        this.customer_name = customer_name;
        this.address = address;
        this.phone = phone;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
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
}
