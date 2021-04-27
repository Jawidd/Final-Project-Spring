package hu.cs.onlineshop;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import hu.cs.onlineshop.model.Customer;
import hu.cs.onlineshop.repository.CustomerRepository;


@SpringBootApplication
public class OnlineShopApplication implements CommandLineRunner {


@Autowired
BCryptPasswordEncoder bCryptPasswordEncoder;

@Autowired
CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(OnlineShopApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		
 		Customer initialCustomer=customerRepository.findByusername("jawid");
if(initialCustomer==null){

		Customer customer1=new Customer(1,"jawid",bCryptPasswordEncoder.encode("jawid"),true);
		customerRepository.save(customer1);


		Customer customer2=new Customer(2,"admin",bCryptPasswordEncoder.encode("admin"),true);
		customerRepository.save(customer2);}
 

	}

}

