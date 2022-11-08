package com.diomedes.bcshoppingcart.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.diomedes.bcshoppingcart.service.ShoppingCartIdGenerator;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {


    @Id
    @Column(name = "shopping_cart_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_shopping_cart_ID")
	@GenericGenerator(name = "SEQ_shopping_cart_ID", strategy = "com.diomedes.bcshoppingcart.service.ShoppingCartIdGenerator", parameters = {
			@Parameter(name = ShoppingCartIdGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = ShoppingCartIdGenerator.VALUE_PREFIX_PARAMETER, value = "BC"),
			@Parameter(name = ShoppingCartIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d") })
    private String id;

    @Column(name = "comment")
    private String comment;

    /*
     * Status
     * A: Active
     * P: Paid
     * R: Payment refused
     * F: Finished
     */
    @Column(name = "status",columnDefinition = "CHAR(1) CHECK(status IN ('C','P','R','F'))")
    private String status;

    @Column(name = "client_id")
    private String clientId;

    @Column(name="client_name")
    private String clientName;

    @Column(name="address")
    private String address;

    @Column(name="type_adress")
    private String typeAdress;

    @OneToMany(mappedBy = "shoppingCart", cascade=CascadeType.ALL, orphanRemoval = true)
    private List<ShoppingCartDetail> detail = new ArrayList<>();
    
}
