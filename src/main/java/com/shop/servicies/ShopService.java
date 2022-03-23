package com.shop.servicies;

import com.shop.controllers.HttpShop;
import com.shop.exceptions.NotFoundException;
import com.shop.repositories.ShopEntity;
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
    public Iterable<ShopEntity> getShopProduct(){
        return shopRepository.getShopProduct();
    }
    public ShopEntity getSpecifiedShopProduct(Integer id) throws NotFoundException {
        return shopRepository.getSpecifiedShopProduct(id);
    }
    public void updateProduct(Integer id, HttpShop httpShop) throws NotFoundException{
        Shop shop = new Shop(httpShop.getProductName(),httpShop.getCompanyName(),httpShop.getPrice());
        shopRepository.updateProduct(id, shop);
    }
    public void deleteProduct(Integer id){
        shopRepository.deleteProduct(id);
    }
}
