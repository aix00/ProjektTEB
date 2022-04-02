package com.shop.repositories;

import com.shop.exceptions.NotFoundException;
import com.shop.servicies.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Repository
public class ShopRepository {

    @Autowired
    ShopDatabaseRepository shopDatabaseRepository;

    //Adding a product
    public String createShopProduct(Shop shop) {
        ShopEntity shopEntity = new ShopEntity(shop.getProductName(),shop.getCompanyName(),shop.getPrice());
        ShopEntity savedEntity = shopDatabaseRepository.save(shopEntity);
        return String.valueOf(savedEntity.getId());
    }

    //Getting a specific product from ShopEntity based on its ID. If it doesn't exist it throws an exception
    public ShopEntity getShopProduct(String id) throws NotFoundException {
        ShopEntity shopEntity = shopDatabaseRepository.findById(Long.parseLong(id)).orElse(null);
        if (shopEntity == null)
                throw new NotFoundException();
        return new ShopEntity(shopEntity.getProductName(), shopEntity.getCompanyName(), shopEntity.getPrice());
    }

    //Getting all products from ShopEntity
    public Collection<Shop> getShopProducts(){
        List<Shop> shops = new ArrayList<>();
        for(ShopEntity shopEntity : shopDatabaseRepository.findAll()) {
            shops.add(new Shop(shopEntity.getProductName(), shopEntity.getCompanyName(), shopEntity.getPrice()));
        }
        return shops;
    }

    //Updating specific product information
    public void updateProduct(String id, Shop shop){
        ShopEntity shopEntity = new ShopEntity(shop.getProductName(), shop.getCompanyName(), shop.getPrice());
        shopEntity.setId(Long.parseLong(id));
        shopDatabaseRepository.save(shopEntity);
    }
    //Deleting specific product information
    public void deleteProduct(String id){
        shopDatabaseRepository.deleteById(Long.parseLong(id));
    }



}
