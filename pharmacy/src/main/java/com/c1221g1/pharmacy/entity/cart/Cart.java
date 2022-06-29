package com.c1221g1.pharmacy.entity.cart;

import com.c1221g1.pharmacy.entity.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;
    @Column(columnDefinition = "BIT")
    private boolean cartStatus;
    @Column(columnDefinition = "DATE")
    private String dateCreate;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "discount_id", referencedColumnName = "discountId")
    private Discount discount;

    @OneToMany(mappedBy = "cart")
    private List<PaymentOnline> paymentOnlineList;
    @OneToMany(mappedBy = "cart")
    private List<CartDetail> cartDetailList;
}
