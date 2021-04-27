
 package hu.cs.onlineshop.service;

 import java.util.List;

import hu.cs.onlineshop.dto.CustomerDTO;
import hu.cs.onlineshop.model.Customer;
 
 public interface CustomerService {
     public Customer addCustomer(Customer customer);
    
     public List<Customer> getAllCustomers();
    
     public Customer getCustomerById(Integer id);  
 
     public void deleteCustomerById(Integer id);
 
     public void deleteAllCustomers();

     public List<CustomerDTO> convertToDTO(List<Customer> customers);

     public CustomerDTO convertToDTO(Customer customer);
 
 }
 
 
 