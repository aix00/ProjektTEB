package com.shop.repositories;

import com.shop.exceptions.NotFoundException;
import com.shop.servicies.Shop;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Optional;


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

    //Getting all products from ShopEntity
    public Iterable<ShopEntity> getShopProduct(){
        return shopDatabaseRepository.findAll();
    }
    //Getting a specific product from ShopEntity based on its ID. If it doesn't exist it throws an exception
    public ShopEntity getShopSpecifiedProduct(Integer id) throws NotFoundException {
        return shopDatabaseRepository.findById(id).orElseThrow(NotFoundException::new);
    }
    //Updating specific product information
    public void updateProduct(Integer id, Shop shop) throws NotFoundException{
        ShopEntity shopEntity = shopDatabaseRepository.findById(id).orElseThrow(NotFoundException::new);
        shopEntity.setProductName(shop.getProductName());
        shopEntity.setPrice(shop.getPrice());
        shopEntity.setCompanyName(shop.getCompanyName());
        shopDatabaseRepository.save(shopEntity);
    }
    //Deleting specific product information
    public void deleteProduct(Integer id){
        shopDatabaseRepository.deleteById(id);
    }



}
