package com.diomedes.bcproducts.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diomedes.bcproducts.dto.external.Product;
import com.diomedes.bcproducts.dto.service.Response;
import com.diomedes.bcproducts.services.ExternalProductsService;

import lombok.extern.slf4j.Slf4j;

@RestController()
@RequestMapping("op-back/V1.0")
@Slf4j
public class MainController {

    private ExternalProductsService eProductsService;

    @Autowired
    public MainController(ExternalProductsService eProductsService) {
        this.eProductsService = eProductsService;
    }

    @GetMapping("products")
    public ResponseEntity<?> getProducts(
            @RequestParam(name = "sort", required = false) String sort) {

        Map<String, String> uriVariables = new HashMap<>();
        List<Product> products= new ArrayList<>();

        try {

            products =  Arrays.asList(eProductsService.getProducts("products", uriVariables));
            
            if(sort != null && !"".equals(sort)){
                if("title!asc".equals(sort) || "title!desc".equals(sort)){
                    Collections.sort(products, new Comparator<Product>() {
                        @Override
                        public int compare(Product o1, Product o2) {
                            return 
                                (   sort.contains("title")?
                                ("title!asc".equals(sort)?o1.getTitle().compareTo(o2.getTitle()):o2.getTitle().compareTo(o1.getTitle())):
                                ("price!asc".equals(sort)?o1.getPrice().compareTo(o2.getPrice()):o2.getPrice().compareTo(o1.getPrice()))
                                );
                        }
                    });
                }
            }


        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new Response(products,null,false), HttpStatus.OK);
    }

    @GetMapping(value={"product/{product}","product"})
    public ResponseEntity<?> getProduct(@PathVariable("product") Optional<Integer> productRequest) {

        if(productRequest.isPresent()){
            
        Map<String, String> uriVariables = new HashMap<>();
        Product product = eProductsService.getProduct("products/"+productRequest.get(), uriVariables);
        return new ResponseEntity<>(new Response(product,null,false),HttpStatus.OK);

        }else{
            return new ResponseEntity<>(new Response(null,"Error. Check request",true),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
