package com.c1221g1.pharmacy.service.invoice.impl;

import com.c1221g1.pharmacy.dto.invoice.InvoiceDto;
import com.c1221g1.pharmacy.dto.invoice.InvoiceMedicineDto;
import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.entity.employee.Employee;
import com.c1221g1.pharmacy.entity.invoice.Invoice;
import com.c1221g1.pharmacy.entity.invoice.InvoiceMedicine;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import com.c1221g1.pharmacy.entity.medicine.MedicineStorage;
import com.c1221g1.pharmacy.repository.customer.ICustomerRepository;
import com.c1221g1.pharmacy.repository.employee.IEmployeeRepository;
import com.c1221g1.pharmacy.repository.invoice.IInvoiceMedicineRepository;
import com.c1221g1.pharmacy.repository.medicine.IMedicineRepository;
import com.c1221g1.pharmacy.service.invoice.IInvoiceMedicineService;
import com.c1221g1.pharmacy.service.invoice.IInvoiceService;
import com.c1221g1.pharmacy.service.medicine.IMedicineStorageService;
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
    private ICustomerRepository iCustomerRepository;

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Autowired
    private IMedicineRepository iMedicineRepository;

    @Autowired
    private IMedicineStorageService iMedicineStorageService;

    /*
     * Created by DaLQA
     * Time: 10:30 PM 29/06/2022
     * Function: function createInvoiceMedicine
     * */
    @Override
    public boolean saveInvoiceMedicine(InvoiceDto invoiceDto) throws Exception {
        List<InvoiceMedicineDto> invoiceMedicineList = invoiceDto.getInvoiceMedicineList();
        for (InvoiceMedicineDto item : invoiceMedicineList) {
            MedicineStorage medicineStorage = this.iMedicineStorageService
                    .getStorageByIdMedicine(item.getMedicineId()).get();
            Long quantityCurrentMedicine = medicineStorage.getMedicineQuantity();
            if (quantityCurrentMedicine - item.getQuantity() < 0) {
                throw new Exception("hết thuốc");
            }
            medicineStorage.setMedicineQuantity(quantityCurrentMedicine - item.getQuantity());
        }

        Employee employee = this.iEmployeeRepository.findById(invoiceDto.getEmployeeId()).orElse(null);
        Customer customer = this.iCustomerRepository.findById(invoiceDto.getCustomerId()).orElse(null);
        Invoice invoice = new Invoice();
        invoice.setEmployee(employee);
        invoice.setCustomer(customer);
        invoice.setInvoiceNote(invoiceDto.getInvoiceNote());
        Invoice newInvoice = iInvoiceService.saveInvoice(invoice);

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
