package com.c1221g1.pharmacy.entity.import_invoice;

import com.c1221g1.pharmacy.entity.employee.Employee;
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
public class ImportInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer importInvoiceId;
    private Integer importSystemCode;
    private Integer accountingVoucherNumber;
    @Column(columnDefinition = "DATE")
    private String importInvoiceDate;
    @Column(columnDefinition = "BIT")
    private boolean flag;

    @ManyToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "paymentId")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "supplierId")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employeeId")
    private Employee employee;
    @JsonBackReference
    @OneToMany(mappedBy = "importInvoice")
    private List<ImportInvoiceMedicine> importInvoiceMedicineList;
}
