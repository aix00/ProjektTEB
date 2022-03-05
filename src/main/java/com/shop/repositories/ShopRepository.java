package com.shop.repositories;

import com.shop.servicies.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public class ShopRepository {

    @Autowired
    private ShopDatabaseRepository shopDatabaseRepository;

    public String createShopProduct(Shop shop) {
        String id = UUID.randomUUID().toString();
        ShopEntity shopEntity = new ShopEntity(shop.getProductName(),shop.getCompanyName(),shop.getPrice());
        ShopEntity savedEntity = shopDatabaseRepository.save(ShopEntity);
        return String.valueOf(savedEntity.getId());
    }
}
