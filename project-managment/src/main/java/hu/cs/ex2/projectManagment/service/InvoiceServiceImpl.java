package hu.cs.ex2.projectManagment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.cs.ex2.projectManagment.model.Invoice;
import hu.cs.ex2.projectManagment.repository.InvoiceRepository;

/**
 * InvoiceService Impl
 */
@Service
public class InvoiceServiceImpl implements InvoiceService {

@Autowired
InvoiceRepository invoiceRepository;

    @Override
    public Invoice addInvoice(Invoice invoice) {
        
        return invoiceRepository.save(invoice);
    }

    @Override
    public void deleteInvoiceById(Integer id) {
        invoiceRepository.deleteById(id);

    }

    @Override
    public List<Invoice> getAllInvoices() {
       
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoiceById(Integer id) {
       
        return invoiceRepository.getOne(id);
    }


    
}