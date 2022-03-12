package com.shop.repositories;

import com.shop.servicies.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public class ShopRepository {

    @Autowired
    private ShopDatabaseRepository shopDatabaseRepository;

    //Adding a product
    public String createShopProduct(Shop shop) {
        String id = UUID.randomUUID().toString();
        ShopEntity shopEntity = new ShopEntity(shop.getProductName(),shop.getCompanyName(),shop.getPrice());
        ShopEntity savedEntity = shopDatabaseRepository.save(shopEntity);
        return String.valueOf(savedEntity.getId());
    }

    //Getting all products from ShopEntity
    public Iterable<ShopEntity> getShopProduct(){
        return shopDatabaseRepository.findAll();
    }
    //Getting a specific product from ShopEntity based on its ID
    public Optional<ShopEntity> getShopSpecifiedProduct(long id){
        return shopDatabaseRepository.findById(id);
    }



}
