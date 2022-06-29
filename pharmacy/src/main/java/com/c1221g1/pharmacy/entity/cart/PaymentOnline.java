package com.c1221g1.pharmacy.entity.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentOnline {
    @Id
    @Column(columnDefinition = "VARCHAR(20)")
    @GeneratedValue(generator = "payment-id-generator")
    @GenericGenerator(name = "payment-id-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "HDO"),
            strategy = "com.c1221g1.pharmacy.common.IdentityCodeGenerator")
    private String paymentId;
    private Double discount;
    @JoinColumn(columnDefinition = "DATETIME")
    private String timeCreate;
    private String note;
    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "cartId")
    private Cart cart;
}
