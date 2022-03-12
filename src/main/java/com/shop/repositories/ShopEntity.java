package com.shop.repositories;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ShopEntity {
    //Informacje na temat sprzedawanych produktów.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String productName; //nazwa produktu
    private String companyName; //nazwa firmy produkującej produkt
    private Double price;

    public ShopEntity(String productName, String companyName, Double price) {
        this.productName = productName;
        this.companyName = companyName;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
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
                ", productName='" + productName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", price=" + price +
                '}';
    }
}
