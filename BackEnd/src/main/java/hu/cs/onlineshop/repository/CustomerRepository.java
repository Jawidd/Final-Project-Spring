package hu.cs.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.cs.onlineshop.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    
    Customer findByusername(String username);
}
