package com.project.cart.repositories;

import com.project.shop.repositories.ShopEntity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Cart")
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToMany(fetch = FetchType.EAGER)
    private List<ShopEntity> products;

    CartEntity(){
    }

    public CartEntity(List<ShopEntity> products) {
        this.products = products;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<ShopEntity> getProducts() {
        return this.products;
    }

    public void setProducts(List<ShopEntity> products) {
        this.products = products;
    }


}
