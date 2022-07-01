package com.c1221g1.pharmacy.entity.invoice;

import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.entity.employee.Employee;
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
@JsonIgnoreProperties({"customer","employee","typeOfInvoice"})
public class Invoice {
    @Id
    @Column(columnDefinition = "VARCHAR(20)")
    @GeneratedValue(generator = "prod-generator")
    @GenericGenerator(name = "prod-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "HD"),
            strategy = "com.c1221g1.pharmacy.common.IdentityCodeGenerator")
    private String invoiceId;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employeeId")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "type_of_invoice_id", referencedColumnName = "typeOfInvoiceId")
    private TypeOfInvoice typeOfInvoice;
    @Column(columnDefinition = "LONGTEXT")
    private String invoiceNote;
    private String invoiceCreatedDate;
    /*
     * Created by DaLQA
     * Time: 8:36 PM 30/06/2022
     * Function: create new property invoiceCreateTime
     * */
    private Double invoiceTotalMoney;
    /*
     * Created by DaLQA
     * Time: 4:12 PM 29/06/2022
     * Function: create new property invoiceCreateTime
     * */
    private String invoiceCreateTime;
    @Column(columnDefinition = "BIT")
    private boolean flag;
    @OneToMany(mappedBy = "invoice")
    private List<InvoiceMedicine> invoiceMedicineList;
}
