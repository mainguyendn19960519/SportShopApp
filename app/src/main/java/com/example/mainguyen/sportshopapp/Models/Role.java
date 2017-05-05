package com.example.mainguyen.sportshopapp.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ha.dinh on 4/19/2017.
 */

public class Role implements java.io.Serializable  {
    private int orderId;
    private List<ProductOrder> productOrder;
    private Date orderDate;
    private boolean status = false;
    private double total;
    private Staffs staffInformation;

    public Staffs getStaffInformation() {
        return staffInformation;
    }

    public void setStaffInformation(Staffs staffInformation) {
        this.staffInformation = staffInformation;
    }

    private String customerName;
    private String address;
    private String phone;
    private List<ProductOrder> products = new ArrayList<ProductOrder>();
//
//
//	public Order(int orderId, Date orderDate, boolean status, double total, StaffInformation staffInformation,
//			String customerName, String address, String phone) {
//		super();
//		this.orderId = orderId;
//		this.orderDate = orderDate;
//		this.status = status;
//		this.total = total;
//		this.staffInformation = staffInformation;
//		this.customerName = customerName;
//		this.address = address;
//		this.phone = phone;
//	}

//	public Order(int orderId, Date orderDate, boolean status, double total, StaffInformation staffInformation,
//			String customerName, String address, String phone, List<ProductOrder> products) {
//		super();
//		this.orderId = orderId;
//		this.orderDate = orderDate;
//		this.status = status;
//		this.total = total;
//		this.staffInformation = staffInformation;
//		this.customerName = customerName;
//		this.address = address;
//		this.phone = phone;
//		this.products = products;
//	}

    public List<ProductOrder> getProducts() {
        return products;
    }

    public void setProducts(List<ProductOrder> products) {
        this.products = products;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public List<ProductOrder> getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(List<ProductOrder> productOrder) {
        this.productOrder = productOrder;
    }
}
