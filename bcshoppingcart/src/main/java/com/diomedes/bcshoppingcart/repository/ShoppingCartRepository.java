package com.diomedes.bcshoppingcart.repository;

import org.springframework.data.repository.CrudRepository;

import com.diomedes.bcshoppingcart.entity.ShoppingCart;

public interface ShoppingCartRepository  extends CrudRepository<ShoppingCart, String>{
    
}
