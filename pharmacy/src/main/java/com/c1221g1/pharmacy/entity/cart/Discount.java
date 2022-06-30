package com.c1221g1.pharmacy.entity.cart;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Discount {
    @Id
    @Column(columnDefinition = "VARCHAR(20)")
    private String discountId;
    private Double discountValue;

    @JsonBackReference(value = "cartList")
    @OneToMany(mappedBy = "discount")
    private List<Cart> cartList;

}
