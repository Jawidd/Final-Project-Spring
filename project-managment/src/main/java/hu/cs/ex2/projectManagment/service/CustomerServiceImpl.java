package hu.cs.ex2.projectManagment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.cs.ex2.projectManagment.dto.CustomerDTO;
import hu.cs.ex2.projectManagment.model.Customer;
import hu.cs.ex2.projectManagment.repository.CustomerRepository;

/**
 * CustomerServiceImpl
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Customer addCustomer(Customer customer) {

        return customerRepository.save(customer);
    }

    @Override
    public void deleteAllCustomers() {
        customerRepository.deleteAll();

    }

    @Override
    public void deleteCustomerById(Integer id) {
        customerRepository.deleteById(id);

    }

    @Override
    public List<Customer> getAllCustomers() {

        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Integer id) {

        return customerRepository.getOne(id);
    }

    @Override
    public List<CustomerDTO> convertToDTO(List<Customer> customers) {
        
        List<CustomerDTO> customerDTOList=new ArrayList<>();

        for(Customer customer:customers){
            CustomerDTO customerDTO =modelMapper.map(customer, CustomerDTO.class);

            customerDTO.setInvoicesIds(customer.getInvoices().stream().map(invo->invo.getId()).collect(Collectors.toList()));

            customerDTOList.add(customerDTO);
        }
        
        return customerDTOList;
    }



    @Override
    public CustomerDTO convertToDTO(Customer customer) {
        return modelMapper.map(customer,CustomerDTO.class);
    }

   

    
}