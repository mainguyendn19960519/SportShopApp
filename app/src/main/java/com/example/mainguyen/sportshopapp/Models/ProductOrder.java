package com.example.mainguyen.sportshopapp.Models;

/**
 * Created by ha.dinh on 4/19/2017.
 */

public class ProductOrder implements java.io.Serializable  {
    private int productOrderId;
    private Order order;
    private Product product;
    private int quantity;

    public ProductOrder() {
        super();
    }

    public ProductOrder(Order order, Product product, int quantity) {
        super();
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public int getProductOrderId() {
        return productOrderId;
    }

    public void setProductOrderId(int productOrderId) {
        this.productOrderId = productOrderId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
