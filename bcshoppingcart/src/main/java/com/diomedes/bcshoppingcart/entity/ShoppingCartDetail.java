package com.diomedes.bcshoppingcart.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shopping_cart_detail")
public class ShoppingCartDetail {
    @Column(name = "shopping_cart_detail_id")
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    private Double price;

    private String typePrice;

    private Integer productId;

    private String productTitle;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_shopping_cart_id"), name="shopping_cart_id", referencedColumnName = "shopping_cart_id", columnDefinition = "varchar(10)")
    private ShoppingCart shoppingCart;
}
