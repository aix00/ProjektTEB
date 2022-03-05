package com.shop.repositories;

import org.springframework.data.repository.CrudRepository;

interface ShopDatabaseRepository extends CrudRepository<ShopEntity, Long> {
}
