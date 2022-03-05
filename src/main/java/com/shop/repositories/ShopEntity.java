package com.shop.repositories;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ShopEntity {
    //Informacje na temat sprzedawanych produktów.
    @Id
    @GeneratedValue
    private long id;
    public String productName; //nazwa produktu
    public String companyName; //nazwa firmy produkującej produkt
    public Double price;

    public ShopEntity(long id, String productName, String companyName, Double price) {
        this.id = id;
        this.productName = productName;
        this.companyName = companyName;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ShopEntity{" +
                "id=" + id +
                ", name='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}
