package com.javaeat.model;

import com.javaeat.enums.CartStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "cart")
@AllArgsConstructor
public class Cart extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Integer id;
    @Column(name = "total_price")
    private Double totalPrice = 0.0;
    @Column(name = "total_items")
    private Integer totalItems = 0;  // The count of items in the cart
    @Column(name = "cart_status")
    @Enumerated(EnumType.STRING)
    private CartStatus status;
    @Column(name = "discount")
    private Double discount;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItem> cartItems;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;
    // TODO: add @OneToOne customer

}
