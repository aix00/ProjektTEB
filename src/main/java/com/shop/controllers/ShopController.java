package com.shop.controllers;

import com.shop.exceptions.NotFoundException;
import com.shop.repositories.ShopEntity;
import com.shop.servicies.Shop;
import com.shop.servicies.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class ShopController {
    @Autowired
    private ShopService shopService;

    @PostMapping("/shop")
    public long createShopProduct(@RequestBody HttpShop httpShop){
        return shopService.createShopProduct(httpShop);
    }

    @GetMapping("/shop/{id}")
    public HttpShop getProduct(@PathVariable long id){
        try{
            ShopEntity shopEntity = shopService.getShopProduct(id);
            return new HttpShop(shopEntity.getProductName(), shopEntity.getCompanyName(), shopEntity.getPrice());
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/shop")
    public Collection<HttpShop> getProducts(){
        List<HttpShop> httpShops = new ArrayList<>();
        for(Shop shop : shopService.getShopProducts()){
            httpShops.add(new HttpShop(shop.getProductName(), shop.getCompanyName(), shop.getPrice()));
        }
        return httpShops;
    }

    @PutMapping("/shop/{id}")
    public void updateProduct(@PathVariable long id, @RequestBody HttpShop httpShop){
        try{
            shopService.updateProduct(id, httpShop);
        }catch (NotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/shop/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable long id){
        shopService.deleteProduct(id);
    }
}
