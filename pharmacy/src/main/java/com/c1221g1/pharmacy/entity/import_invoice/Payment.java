package com.c1221g1.pharmacy.entity.import_invoice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;
    private Integer paymentDiscount;
    private Double paymentPrepayment;
    @OneToMany(mappedBy = "payment")
    private List<ImportInvoice> importInvoiceList;
}
