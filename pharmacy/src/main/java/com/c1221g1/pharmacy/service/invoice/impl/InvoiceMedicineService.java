package com.c1221g1.pharmacy.service.invoice.impl;

import com.c1221g1.pharmacy.dto.invoice.InvoiceDto;
import com.c1221g1.pharmacy.dto.invoice.InvoiceMedicineDto;
import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.entity.employee.Employee;
import com.c1221g1.pharmacy.entity.invoice.Invoice;
import com.c1221g1.pharmacy.entity.invoice.InvoiceMedicine;
import com.c1221g1.pharmacy.entity.invoice.TypeOfInvoice;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import com.c1221g1.pharmacy.repository.customer.ICustomerRepository;
import com.c1221g1.pharmacy.repository.employee.IEmployeeRepository;
import com.c1221g1.pharmacy.repository.invoice.IInvoiceMedicineRepository;
import com.c1221g1.pharmacy.repository.invoice.ITypeOfInvoiceRepository;
import com.c1221g1.pharmacy.repository.medicine.IMedicineRepository;
import com.c1221g1.pharmacy.service.invoice.IInvoiceMedicineService;
import com.c1221g1.pharmacy.service.invoice.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceMedicineService implements IInvoiceMedicineService {
    @Autowired
    private IInvoiceMedicineRepository invoiceMedicineRepository;

    @Autowired
    private IInvoiceService iInvoiceService;

    @Autowired
    ICustomerRepository iCustomerRepository;

    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @Autowired
    IMedicineRepository iMedicineRepository;

    @Autowired
    ITypeOfInvoiceRepository iTypeOfInvoiceRepository;

    /*
     * Created by DaLQA
     * Time: 10:30 PM 29/06/2022
     * Function: function createInvoiceMedicine
     * */
    @Override
    public boolean saveInvoiceMedicine(InvoiceDto invoiceDto) {
        Employee employee = this.iEmployeeRepository.findById(invoiceDto.getEmployeeId()).orElse(null);
        Customer customer = this.iCustomerRepository.findById(invoiceDto.getCustomerId()).orElse(null);
        TypeOfInvoice typeOfInvoice = this.iTypeOfInvoiceRepository.findById(invoiceDto.getTypeOfInvoiceId()).orElse(null);
        Invoice invoice = new Invoice();
        invoice.setEmployee(employee);
        invoice.setCustomer(customer);
        invoice.setTypeOfInvoice(typeOfInvoice);
        invoice.setInvoiceNote(invoiceDto.getInvoiceNote());
        Invoice newInvoice = iInvoiceService.saveInvoice(invoice);
        List<InvoiceMedicineDto> invoiceMedicineList = invoiceDto.getInvoiceMedicineList();
        for (InvoiceMedicineDto invoiceMedicineDto : invoiceMedicineList) {
            InvoiceMedicine invoiceMedicine = new InvoiceMedicine();
            Medicine medicine = iMedicineRepository.findById(invoiceMedicineDto.getMedicineId()).orElse(null);
            invoiceMedicine.setMedicine(medicine);
            invoiceMedicine.setInvoice(newInvoice);
            invoiceMedicine.setInvoiceMedicineQuantity(invoiceMedicineDto.getQuantity());
            this.invoiceMedicineRepository.save(invoiceMedicine);
        }
        if (newInvoice != null) {
            return true;
        } else {
            return false;
        }
    }
}
