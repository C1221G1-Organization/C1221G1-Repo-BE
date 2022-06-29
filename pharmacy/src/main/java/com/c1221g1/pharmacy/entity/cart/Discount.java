package com.c1221g1.pharmacy.entity.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    @OneToMany(mappedBy = "discount")
    private List<Cart> cartList;

}
