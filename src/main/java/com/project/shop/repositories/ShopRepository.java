package com.project.shop.repositories;

import com.project.shop.exceptions.NotFoundException;
import com.project.shop.servicies.Shop;
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
    public long createShopProduct(Shop shop) {
        ShopEntity shopEntity = new ShopEntity(shop.getProductName(),shop.getCompanyName(),shop.getPrice());
        ShopEntity savedEntity = shopDatabaseRepository.save(shopEntity);
        return savedEntity.getId();
    }

    //Getting a specific product from ShopEntity based on its ID. If it doesn't exist it throws an exception
    public ShopEntity getShopProduct(long id) throws NotFoundException {
        ShopEntity shopEntity = shopDatabaseRepository.findById(id).orElse(null);
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
    public void updateProduct(long id, Shop shop){
        ShopEntity shopEntity = new ShopEntity(shop.getProductName(), shop.getCompanyName(), shop.getPrice());
        shopEntity.setId(id);
        shopDatabaseRepository.save(shopEntity);
    }
    //Deleting specific product information
    public void deleteProduct(long id){
        shopDatabaseRepository.deleteById(id);
    }



}
