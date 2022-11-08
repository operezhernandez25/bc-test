package com.diomedes.bcshoppingcart.advices;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.diomedes.bcshoppingcart.dto.service.Response;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
    public Response handleAuthenticationException(org.springframework.http.converter.HttpMessageNotReadableException ex, HttpServletResponse response){
        Response genericResponseBean = new Response(null,"Error. Review Petition",true);
   
        return genericResponseBean;
    }
}