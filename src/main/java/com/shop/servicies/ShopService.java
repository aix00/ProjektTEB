package com.shop.servicies;

import com.shop.controllers.HttpShop;
import com.shop.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
    @Autowired
    private ShopRepository shopRepository;

    public String createShopProduct(HttpShop httpShop) {
        Shop shop = new Shop(httpShop.getProductName(), httpShop.getCompanyName(), httpShop.getPrice());
        return shopRepository.createShopProduct(shop);
    }
}
