use c1221g1_pharmacy;
select *
    from customer
where customer_type_id = 2 and flag = 1;

Select      '20' day,
            sum((if(i.type_of_invoice_id = 1,
                    ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)
                        *m.medicine_retail_sale_profit),
                    ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)
                        *m.medicine_wholesale_profit)))) revenue,
            sum((if(i.type_of_invoice_id = 1,
                    ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)
                        *(m.medicine_retail_sale_profit-1),
                    ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)
                        *(m.medicine_wholesale_profit-1)))) profit
from invoice i
         inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id
         inner join medicine m on ic.medicine_id = m.medicine_id
Where (day(i.invoice_created_date)='20' and month(i.invoice_created_date)=:month and
       year(i.invoice_created_date)=:year);
Select i.invoice_id invoiceId,
            i.invoice_created_date createdDay,
            i.employee_id employeeId,
            sum((if(i.type_of_invoice_id = 1,
            ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)
                                        *m.medicine_retail_sale_profit),
            ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)
                                          *m.medicine_wholesale_profit)))) total,
            sum((if(i.type_of_invoice_id = 1,
            ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)
                  *(m.medicine_retail_sale_profit-1),
            ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)
              *(m.medicine_wholesale_profit-1)))) profit
            from invoice i
            inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id
            inner join medicine m on ic.medicine_id = m.medicine_id
            Where ((i.invoice_created_date>='2022-05-21') and (i.invoice_created_date<='2022-06-21'))
            Group by i.invoice_id;