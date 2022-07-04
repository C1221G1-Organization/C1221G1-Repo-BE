package com.c1221g1.pharmacy.entity.invoice;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"invoiceList"})
public class TypeOfInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeOfInvoiceId;
    private String typeOfInvoiceName;
    @OneToMany(mappedBy = "typeOfInvoice")
    private List<Invoice> invoiceList;

    public Integer getTypeOfInvoiceId() {
        return typeOfInvoiceId;
    }

    public void setTypeOfInvoiceId(Integer typeOfInvoiceId) {
        this.typeOfInvoiceId = typeOfInvoiceId;
    }

    public String getTypeOfInvoiceName() {
        return typeOfInvoiceName;
    }

    public void setTypeOfInvoiceName(String typeOfInvoiceName) {
        this.typeOfInvoiceName = typeOfInvoiceName;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }
}