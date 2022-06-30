package com.c1221g1.pharmacy.entity.import_invoice;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Supplier {
    @Id
    @Column(columnDefinition = "VARCHAR(20)")
    @GeneratedValue(generator = "prod-generator")
    @GenericGenerator(name = "prod-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "NCC"),
            strategy = "com.c1221g1.pharmacy.common.IdentityCodeGenerator")
    private String supplierId;
    private String supplierName;
    private String supplierAddress;
    private String supplierPhone;
    private String supplierEmail;
    @Column(columnDefinition = "TEXT")
    private String note;

    @Column(columnDefinition = "BIT")
    private boolean flag;

    @JsonBackReference(value = "importInvoiceList")
    @OneToMany(mappedBy = "supplier")
    private List<ImportInvoice> importInvoiceList;
}

