package com.diomedes.bcproducts.services;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.diomedes.bcproducts.dto.external.Product;

import lombok.extern.slf4j.Slf4j;


@Service
public class ExternalProductsService {

    //Base
    @Value("${com.diomedes.url-api}") private String urlBase;

  
    public Product[] getProducts(String path,Map<String, String> uriVariables ){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Product[]> responseEntity = null;
        HttpHeaders headers = null;

        headers = new HttpHeaders();    
        //All petitions will be GET, for that rease we can ignore body..
        HttpEntity<Object> requestEntity = new HttpEntity<>("", headers);
        
        responseEntity = restTemplate.exchange((urlBase + path),
                HttpMethod.GET, requestEntity, Product[].class,uriVariables);

        return responseEntity.getBody();      
    }

    public Product getProduct(String path,Map<String, String> uriVariables ){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Product> responseEntity = null;
        HttpHeaders headers = null;

        headers = new HttpHeaders();    
        //All petitions will be GET, for that rease we can ignore body..
        HttpEntity<Object> requestEntity = new HttpEntity<>("", headers);
            
        responseEntity = restTemplate.exchange((urlBase + path),
                HttpMethod.GET, requestEntity, Product.class,uriVariables);

        return responseEntity.getBody();      
    }

}
