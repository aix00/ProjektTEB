package com.project.cart.repositories;

import org.springframework.data.repository.CrudRepository;

public interface CartDatabaseRepository extends CrudRepository<CartEntity, Long> {
}
