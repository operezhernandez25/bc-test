package com.diomedes.bcshoppingcart.dto;

import lombok.Data;

@Data
public class RequestShoppingCart {

    private String comment;

    /*
     * Status
     * A: Active
     * P: Paid
     * R: Payment refused
     * F: Finished
     */
    private String status;
    private String clientId;

    private String clientName;

    private String address;
    private String typeAdress;

}
