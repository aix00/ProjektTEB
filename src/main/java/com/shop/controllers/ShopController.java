package com.shop.controllers;

import com.shop.exceptions.NotFoundException;
import com.shop.repositories.ShopEntity;
import com.shop.servicies.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ShopController {
    @Autowired
    private ShopService shopService;

    @PostMapping("/shop")
    public String createShopProduct(@RequestBody HttpShop httpShop){
        return shopService.createShopProduct(httpShop);
    }

    @GetMapping("/shop")
    public Iterable<ShopEntity> getProduct(){
        return shopService.getShopProduct();
    }

    @GetMapping("/shop/{id}")
    public HttpShop getSpecifiedProduct(@PathVariable Integer id){
        try{
            ShopEntity shopEntity = shopService.getSpecifiedShopProduct(id);
            return new HttpShop(shopEntity.getProductName(),shopEntity.getCompanyName(),shopEntity.getPrice());
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/shop/{id}")
    public void updateProduct(@PathVariable Integer id, @RequestBody HttpShop httpShop){
        try{
            shopService.updateProduct(id, httpShop);
        }catch (NotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/shop/{id}")
    public void deleteProduct(@PathVariable Integer id){
        shopService.deleteProduct(id);
    }
}
