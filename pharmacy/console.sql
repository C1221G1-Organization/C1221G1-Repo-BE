use c1221g1_pharmacy;
Select i.invoice_id invoiceId,
            i.invoice_created_date createdDay,
            i.employee_id employeeId,
            (ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)*m.medicine_retail_sale_profit)) total,
            (ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)*(m.medicine_retail_sale_profit-1)) profit
            from invoice i
            inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id
            inner join medicine m on ic.medicine_id = m.medicine_id
            Where ((i.invoice_created_date>=:'2022-01-05') and (i.invoice_created_date<=:'2022-06-05'))
            Group by i.invoice_id;

select i.invoice_id invoiceId,
       i.invoice_created_date createdDay,
       i.employee_id employeeId,
       (ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)*m.medicine_retail_sale_profit)) total,
       (ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)*(m.medicine_retail_sale_profit-1)) profit
from invoice i
         inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id
         inner join medicine m on ic.medicine_id = m.medicine_id
Where ((i.invoice_created_date>=:'2022-01-05') and (i.invoice_created_date<=:'2022-06-05'))
Group by i.employee_id;