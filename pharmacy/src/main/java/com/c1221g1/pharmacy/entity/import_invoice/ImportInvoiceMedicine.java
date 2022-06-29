package com.c1221g1.pharmacy.entity.import_invoice;

import com.c1221g1.pharmacy.entity.medicine.Medicine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ImportInvoiceMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer importInvoiceMedicineId;
    private Integer importInvoiceMedicineDiscountRate;
    @Column(columnDefinition = "DATE")
    private String importInvoiceMedicineExpiry;
    private Integer importInvoiceMedicineImportAmount;
    private Double importInvoiceMedicineImportPrice;
    private Integer importInvoiceMedicineLotNumber;
    private Integer importInvoiceMedicineVat;
    @Column(columnDefinition = "BIT")
    private boolean flag;
    @ManyToOne
    @JoinColumn(name = "medicine_id", referencedColumnName = "medicineId")
    private Medicine medicine;
    @ManyToOne
    @JoinColumn(name = "import_invoice_id", referencedColumnName = "importInvoiceId")
    private ImportInvoice importInvoice;
}
