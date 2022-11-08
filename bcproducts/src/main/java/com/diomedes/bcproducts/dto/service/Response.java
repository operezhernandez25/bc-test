package com.diomedes.bcproducts.dto.service;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    
    @JsonProperty("Data")
    private Object data;


    @JsonProperty("MessageError")
    private String messageError;

    @JsonProperty("Error")
    private boolean error;


}
