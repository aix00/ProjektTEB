package com.project.shop.repositories;

import com.project.cart.repositories.CartEntity;

import javax.persistence.*;

@Entity
public class ShopEntity {
    //Informacje na temat sprzedawanych produktów.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "PRODUCT_NAME", length = 50, nullable = false)
    private String productName; //nazwa produktu
    @Column(name = "COMPANY_NAME", length = 80, nullable = false)
    private String companyName; //nazwa firmy produkującej produkt
    @Column(name = "PRICE", nullable = false, precision = 2)
    private Double price;
    @ManyToOne
    private CartEntity cartEntity;

    ShopEntity(){
    }

    public ShopEntity(String productName, String companyName, Double price) {
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

    public CartEntity getCartEntity() {
        return this.cartEntity;
    }

    public void setCartEntity(CartEntity cartEntity) {
        this.cartEntity = cartEntity;
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
