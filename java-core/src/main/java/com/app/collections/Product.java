package com.app.collections;

public class Product {
    private String name;
    private long price;
    private String model;
    private String productType;

    public Product(String name, long price, String model, String productType) {
        this.name = name;
        this.price = price;
        this.model = model;
        this.productType = productType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
