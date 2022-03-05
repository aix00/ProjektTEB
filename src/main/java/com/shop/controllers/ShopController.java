package com.shop.controllers;

import com.shop.servicies.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {
    @Autowired
    private ShopService shopService;

    @PostMapping("/shop")
    public String createShopProduct(@RequestBody HttpShop httpShop){
        return shopService.createShopProduct(httpShop);
    }
}
