package hu.cs.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.cs.onlineshop.model.Customer;
import hu.cs.onlineshop.model.jwtRequest;
import hu.cs.onlineshop.model.jwtResponse;
import hu.cs.onlineshop.repository.CustomerRepository;
import hu.cs.onlineshop.util.JwtUtility;



@RestController
@CrossOrigin
@RequestMapping("/api")
public class SecurityController {


@Autowired
AuthenticationManager authenticationManager;

@Autowired
JwtUtility jwtUtility;

@Autowired
@Qualifier("userDetailsServiceImpl")
UserDetailsService userDetailsService;

@Autowired
CustomerRepository customerRepository;

@GetMapping("/test")
public String test(){
    return "testedddddddddddddddd";
}


@PostMapping("/register")
public jwtResponse register(@RequestBody Customer customer){

customerRepository.save(customer);
String jwttoken;

UserDetails userDetails=userDetailsService.loadUserByUsername(customer.getusername());

  jwttoken= jwtUtility.generateToken(userDetails);


    return new jwtResponse(customer.getName(),customer.getusername(),jwttoken);


}



    @PostMapping("/authenticate")
    public jwtResponse authenticate(@RequestBody jwtRequest jwtRequest) throws Exception{

        try{
authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
    jwtRequest.getUsername(),jwtRequest.getPassword()
));
}catch(BadCredentialsException e){
    throw new Exception("BadCredentialsExceptionnnnnnnnnnn");
}

UserDetails userDetails=userDetailsService.loadUserByUsername(jwtRequest.getUsername());

String jwttoken=jwtUtility.generateToken(userDetails);

Customer a=customerRepository.findByusername(jwtRequest.getUsername());

        return new jwtResponse(a.getName(),a.getusername(),jwttoken);
    }
    
}
