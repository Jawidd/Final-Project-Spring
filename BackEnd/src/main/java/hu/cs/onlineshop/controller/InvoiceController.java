package hu.cs.onlineshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hu.cs.onlineshop.dto.InvoiceDTO;
import hu.cs.onlineshop.model.Invoice;
import hu.cs.onlineshop.service.InvoiceService;

@RestController
@CrossOrigin
public class InvoiceController {


    
    @Autowired
    InvoiceService invoiceService;

 
    @PostMapping("/invoice/add")
     public ResponseEntity<InvoiceDTO> saveInvoice(@RequestBody Invoice invoice){
    
        InvoiceDTO invoiceDTO=invoiceService.convertToDTO(invoiceService.addInvoice(invoice));
        return new ResponseEntity<>(invoiceDTO,HttpStatus.CREATED);
     }


    @GetMapping("/invoice/getAll")
     public ResponseEntity<List<InvoiceDTO>> getAllInvoices(){
     
        return new ResponseEntity<>(invoiceService.convertToDTO(invoiceService.getAllInvoices()),HttpStatus.OK);
     }


    @GetMapping("/invoice/{id}/getOne")
     public ResponseEntity<InvoiceDTO> getInvoiceById(@PathVariable Integer id){
       
        return new ResponseEntity<>(invoiceService.convertToDTO(invoiceService.getInvoiceById(id)),HttpStatus.OK);

     }

   
    
    @PutMapping("invoice/update")
    public ResponseEntity<InvoiceDTO> updateInvoice(@RequestBody Invoice invoice){
    
        InvoiceDTO invoiceDTO=invoiceService.convertToDTO(invoiceService.addInvoice(invoice));
         return new ResponseEntity<>(invoiceDTO,HttpStatus.CREATED);
      }
    
}
