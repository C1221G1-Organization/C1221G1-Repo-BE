package com.c1221g1.pharmacy.entity.import_invoice;

import com.c1221g1.pharmacy.entity.employee.Employee;
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
public class ImportInvoice {

    @Id
    @Column(columnDefinition = "VARCHAR(20)")
    @GeneratedValue(generator = "prod-generator")
    @GenericGenerator(name = "prod-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "HDN"),
            strategy = "com.c1221g1.pharmacy.common.IdentityCodeGenerator")
    private String importInvoiceId;
    private Integer importSystemCode;
    private Double paymentPrepayment;
    private Double total;
    @Column(columnDefinition = "DATE")
    private String importInvoiceDate;
    private String importInvoiceHour;
    @Column(columnDefinition = "BIT")
    private boolean flag;

    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "supplierId")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employeeId")
    private Employee employee;

    @JsonBackReference(value = "importInvoiceMedicineList")
    @OneToMany(mappedBy = "importInvoice")
    private List<ImportInvoiceMedicine> importInvoiceMedicineList;
}
