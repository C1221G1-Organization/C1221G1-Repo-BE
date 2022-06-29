package com.c1221g1.pharmacy.entity.cart;

import com.c1221g1.pharmacy.entity.medicine.Medicine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart_detail", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "CART_MEDICINE_UK", columnNames = { "medicine_id", "cart_id" }) })
public class CartDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartDetailId;
    private Integer cartDetailQuantity;
    @ManyToOne
    @JoinColumn(name = "medicine_id",referencedColumnName = "medicineId")
    private Medicine medicine;
    @ManyToOne
    @JoinColumn(name = "cart_id",referencedColumnName = "cartId")
    private Cart cart;
}
