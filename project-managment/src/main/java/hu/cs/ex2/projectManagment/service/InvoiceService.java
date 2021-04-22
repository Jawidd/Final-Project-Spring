
 package hu.cs.ex2.projectManagment.service;

 import java.util.List;

import hu.cs.ex2.projectManagment.dto.InvoiceDTO;
import hu.cs.ex2.projectManagment.model.Invoice;
 

 
 public interface InvoiceService {
     public Invoice addInvoice(Invoice invoice);
    
     public List<Invoice> getAllInvoices();
    
     public Invoice   getInvoiceById(Integer id);  
 
     public void deleteInvoiceById(Integer id);
    
     public List<InvoiceDTO> convertToDTO(List<Invoice> invoices);

     public InvoiceDTO convertToDTO(Invoice invoice);
 
     //public void deleteAllInvoices();
 
 }
 
 
 