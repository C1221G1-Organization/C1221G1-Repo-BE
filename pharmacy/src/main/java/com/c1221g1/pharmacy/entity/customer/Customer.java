package com.c1221g1.pharmacy.entity.customer;

import com.c1221g1.pharmacy.entity.cart.Cart;
import com.c1221g1.pharmacy.entity.user.Users;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties({"customerList"})
public class Customer {
    @Id
    @Column(columnDefinition = "VARCHAR(20)")
    @GeneratedValue(generator = "prod-generator")
    @GenericGenerator(name = "prod-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "KH"),
            strategy = "com.c1221g1.pharmacy.common.IdentityCodeGenerator")
    private String customerId;
    private String customerName;
    @Column(columnDefinition = "DATE")
    private String customerBirthday;
    private Integer customerGender;
    private String customerAddress;
    private String customerPhone;
    private String customerNote;
    @Column(columnDefinition = "BIT")
    private boolean flag;
    @JsonBackReference(value = "customerUsername")
    @OneToOne
    @JoinColumn(name = "customer_username", referencedColumnName = "username")
    private Users customerUsername;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "customerTypeId")
    private CustomerType customerType;
    @JsonBackReference(value = "cartList")
    @OneToMany(mappedBy = "customer")
    private List<Cart> cartList;
}
