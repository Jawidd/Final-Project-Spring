package hu.cs.onlineshop.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import hu.cs.onlineshop.filter.JwtFilter;

/**
 * SecurityConfig
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {



@Autowired
@Qualifier("userDetailsServiceImpl")
private  UserDetailsService userDetailsService;

@Autowired
JwtFilter jwtFilter;

@Override
protected void configure(HttpSecurity http) throws Exception {

    http.csrf().disable()
    .authorizeRequests()
    .antMatchers("/api/authenticate").permitAll()
    .antMatchers("/api/register").permitAll()
    .antMatchers("/api/test").permitAll()
    .anyRequest()
    .authenticated()
    .and()
    .sessionManagement()
    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
}

    //http.addFilterBefore(filter, beforeFilter)

@Bean
    AuthenticationProvider ap(){

        DaoAuthenticationProvider daoAuthProv=new DaoAuthenticationProvider();
        daoAuthProv.setPasswordEncoder(new BCryptPasswordEncoder());
        daoAuthProv.setUserDetailsService(userDetailsService);
            return daoAuthProv;

    }

    @Bean
public BCryptPasswordEncoder bCryptPasswordEncoder(){
    return new BCryptPasswordEncoder();
};
 
@Bean
public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
}


     


    
}