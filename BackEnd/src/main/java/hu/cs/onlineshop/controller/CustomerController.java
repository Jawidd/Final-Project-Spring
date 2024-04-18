package hu.cs.onlineshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.cs.onlineshop.dto.CustomerDTO;
import hu.cs.onlineshop.model.Customer;
import hu.cs.onlineshop.service.CustomerService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@CrossOrigin
@RequestMapping("/api")
public class CustomerController {


    @Autowired
    CustomerService customerService;

 
    @PostMapping("/customer/add")
     public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody Customer customer){
    
       CustomerDTO customerDTO=customerService.convertToDTO(customerService.addCustomer(customer));
        return new ResponseEntity<>(customerDTO,HttpStatus.CREATED);
     }


    @GetMapping("/customer/getAll")
     public ResponseEntity<List<CustomerDTO>> getAllCustomers(){
     
        return new ResponseEntity<>(customerService.convertToDTO(customerService.getAllCustomers()),HttpStatus.OK);
     }


    @GetMapping("/customer/{id}/getOne")
     public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Integer id){
       
        return new ResponseEntity<>(customerService.convertToDTO(customerService.getCustomerById(id)),HttpStatus.OK);

     }

    @DeleteMapping("/customer/{id}/delete")
    public void deleteCustomerById(@PathVariable Integer id){
        
        customerService.deleteCustomerById(id);
     }
    
    @PutMapping(value="customer/update")
    public ResponseEntity<CustomerDTO> edithCustomer(@RequestBody Customer customer){
    
        CustomerDTO customerDTO=customerService.convertToDTO(customerService.addCustomer(customer));
         return new ResponseEntity<>(customerDTO,HttpStatus.CREATED);
      }
     

    
}
