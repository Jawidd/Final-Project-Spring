
 package hu.cs.ex2.projectManagment.service;

 import java.util.List;

import hu.cs.ex2.projectManagment.model.Invoice;
 

 
 public interface InvoiceService {
     public Invoice addInvoice(Invoice invoice);
    
     public List<Invoice> getAllInvoices();
    
     public Invoice   getInvoiceById(Integer id);  
 
     public void deleteInvoiceById(Integer id);
 
     //public void deleteAllInvoices();
 
 }
 
 
 