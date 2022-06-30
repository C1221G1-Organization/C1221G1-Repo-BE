package com.c1221g1.pharmacy.entity.employee;

import com.c1221g1.pharmacy.entity.import_invoice.ImportInvoice;
import com.c1221g1.pharmacy.entity.user.Users;
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
public class Employee {
    @Id
    @Column(columnDefinition = "VARCHAR(20)")
    @GeneratedValue(generator = "prod-generator")
    @GenericGenerator(name = "prod-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "NV"),
            strategy = "com.c1221g1.pharmacy.common.IdentityCodeGenerator")
    private String employeeId;
    private String employeeName;
    @Column(columnDefinition = "LONGTEXT")
    private String employeeImage;
    private String employeeAddress;
    private String employeePhone;
    @Column(columnDefinition = "DATE")
    private String employeeDateStart;

    private String employeeNote;
    @Column(columnDefinition = "BIT")
    private boolean flag;
    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "positionId")
    private Position position;

    @JsonBackReference(value = "employeeUsername")
    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private Users employeeUsername;

    @JsonBackReference(value = "importInvoiceList")
    @OneToMany(mappedBy = "employee")
    private List<ImportInvoice> importInvoiceList;
}
