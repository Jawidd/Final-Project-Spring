package hu.cs.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.cs.onlineshop.model.Invoice;


@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
    
}
