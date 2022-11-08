package com.diomedes.bcshoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diomedes.bcshoppingcart.dto.RequestShoppingCart;

@RestController
@RequestMapping("op-back/V1.0")
public class MainController {
    
    @Autowired
    public MainController(){

    }

    @PostMapping("shopping-cart")
    public ResponseEntity<?> saveShoppingCart(@RequestBody  RequestShoppingCart  body){

       return  new ResponseEntity<>("Hola Mundo", HttpStatus.OK);
    }
}
