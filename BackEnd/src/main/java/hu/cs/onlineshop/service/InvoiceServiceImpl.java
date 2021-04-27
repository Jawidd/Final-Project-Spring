package hu.cs.onlineshop.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.cs.onlineshop.dto.InvoiceDTO;
import hu.cs.onlineshop.model.Invoice;
import hu.cs.onlineshop.repository.InvoiceRepository;

/**
 * InvoiceService Impl
 */
@Service
public class InvoiceServiceImpl implements InvoiceService {


    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    ModelMapper modelMapper;

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

    @Override
    public List<InvoiceDTO> convertToDTO(List<Invoice> invoices) {
          
        List<InvoiceDTO> invoiceDTOList=new ArrayList<>();

        for(Invoice invoice:invoices){
            InvoiceDTO invoiceDTO =modelMapper.map(invoice, InvoiceDTO.class);
            invoiceDTOList.add(invoiceDTO);
        }
        
        return invoiceDTOList;
        
        
    }

    @Override
    public InvoiceDTO convertToDTO(Invoice invoice) {
        
        return modelMapper.map(invoice, InvoiceDTO.class);
    }


    
}