package com.example.mainguyen.sportshopapp.Models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ha.dinh on 4/19/2017.
 */

public class Size implements Serializable {
    private int sizeId;
    private String typeOfSize;
    private List<Product> productId;

    public Size(int sizeId, String typeOfSize) {
        super();
        this.sizeId = sizeId;
        this.typeOfSize = typeOfSize;
    }

    public Size() {
        super();
    }

    public Size(int sizeId, String typeOfSize, List<Product> productId) {
        super();
        this.sizeId = sizeId;
        this.typeOfSize = typeOfSize;
        this.productId = productId;
    }

    public List<Product> getProduct() {
        return productId;
    }

    public void setProduct(List<Product> productId) {
        this.productId = productId;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public String getTypeOfSize() {
        return typeOfSize;
    }

    public void setTypeOfSize(String typeOfSize) {
        this.typeOfSize = typeOfSize;
    }

}
