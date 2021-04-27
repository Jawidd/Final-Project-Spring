package hu.cs.onlineshop.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hu.cs.onlineshop.model.Customer;
import hu.cs.onlineshop.repository.CustomerRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    
@Autowired
CustomerRepository customerRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Customer a=customerRepository.findByusername(username);

        
        return new org.springframework.security.core.userdetails.User(a.getusername(),a.getPassword(),new ArrayList<>());
    }
}
