package com.c1221g1.pharmacy.entity.invoice;

import com.c1221g1.pharmacy.entity.medicine.Medicine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invoice_medicine",
        uniqueConstraints = {
                @UniqueConstraint(name = "INVOICE_MEDICINE_UK", columnNames = {"invoice_id", "medicine_id"})})
public class InvoiceMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer invoiceMedicineId;
    private Integer invoiceMedicineQuantity;
    @ManyToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "invoiceId")
    private Invoice invoice;
    @ManyToOne
    @JoinColumn(name = "medicine_id", referencedColumnName = "medicineId")
    private Medicine medicine;
}
