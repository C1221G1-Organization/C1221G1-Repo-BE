package com.c1221g1.pharmacy.entity.invoice;

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
public class TypeOfInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeOfInvoiceId;
    private String typeOfInvoiceName;
    @OneToMany(mappedBy = "typeOfInvoice")
    private List<Invoice> invoiceList;
}
