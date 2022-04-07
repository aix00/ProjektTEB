package com.shop.servicies;

import com.shop.controllers.HttpShop;
import com.shop.exceptions.NotFoundException;
import com.shop.repositories.ShopEntity;
import com.shop.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ShopService {
    @Autowired
    private ShopRepository shopRepository;

    public long createShopProduct(HttpShop httpShop) {
        Shop shop = new Shop(httpShop.getProductName(), httpShop.getCompanyName(), httpShop.getPrice());
        return shopRepository.createShopProduct(shop);
    }

    public ShopEntity getShopProduct(long id) throws NotFoundException {
        return shopRepository.getShopProduct(id);
    }

    public Collection<Shop> getShopProducts(){
        return shopRepository.getShopProducts();

    }

    public void updateProduct(long id, HttpShop httpShop) throws NotFoundException{
        Shop shop = new Shop(httpShop.getProductName(), httpShop.getCompanyName(), httpShop.getPrice());
        shopRepository.updateProduct(id, shop);
    }
    public void deleteProduct(long id){
        shopRepository.deleteProduct(id);
    }
}
