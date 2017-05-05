package com.example.mainguyen.sportshopapp.Models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ha.dinh on 4/19/2017.
 */

public class Product implements Serializable {
    private int productId;
    private List<ProductOrder> productOrder;
    private String productName;
    private int quantity;
    private String dateUpdate;
    private Size size;

//	@NotNull
//	@Column(name = "size_id", insertable = false, updatable = false)
//	private int size_id;

//	public int getSize_id() {
//		return size_id;
//	}

    //	public void setSize_id(int size_id) {
//		this.size_id = size_id;
//	}
    private float price;
    private String description;
    private String image;
    private int status;

    public Product(int productId, Integer quantity) {
        super();
        this.productId = productId;
        this.quantity = quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product(String productName, Integer quantity, String dateUpdate, Size size, float price, String description,
                   String image, int status) {
        super();
        this.productName = productName;
        this.quantity = quantity;
        this.dateUpdate = dateUpdate;
        this.size = size;
        this.price = price;
        this.description = description;
        this.image = image;
        this.status = status;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProductOrder> getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(List<ProductOrder> productOrder) {
        this.productOrder = productOrder;
    }
    @Override
    public String toString() {
        return "Departments{" +
                "id=" + productId +
                ", depCode='" + productName + '\'' +
                ", depName='" + quantity + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + image + '\'' +
                '}';
    }
}
