
 package hu.cs.onlineshop.service;

 import java.util.List;

import hu.cs.onlineshop.dto.InvoiceDTO;
import hu.cs.onlineshop.model.Invoice;
 

 
 public interface InvoiceService {
     public Invoice addInvoice(Invoice invoice);
    
     public List<Invoice> getAllInvoices();
    
     public Invoice   getInvoiceById(Integer id);  
 
     public void deleteInvoiceById(Integer id);
    
     public List<InvoiceDTO> convertToDTO(List<Invoice> invoices);

     public InvoiceDTO convertToDTO(Invoice invoice);
 
     //public void deleteAllInvoices();
 
 }
 
 
 