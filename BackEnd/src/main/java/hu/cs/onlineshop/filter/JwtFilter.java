

package hu.cs.onlineshop.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import hu.cs.onlineshop.util.JwtUtility;

/**
 * JwtFilter
 */
@Component
 public class JwtFilter extends OncePerRequestFilter {

@Autowired
JwtUtility jwtUtility;


@Autowired
@Qualifier("userDetailsServiceImpl")
private  UserDetailsService userDetailsService;

@Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
          throws ServletException, IOException {
     
     String header=request.getHeader("Authentication");
     String jwttoken=null;
     String username=null;

     if(header != null && header.startsWith("Bearer ")){
     jwttoken=header.substring(7);
     username=jwtUtility.getUsernameFromToken(jwttoken);
}


     if(username != null){
          UserDetails userDetails=userDetailsService.loadUserByUsername(username);

         if( jwtUtility.validateToken(jwttoken, userDetails)    ){
              
UsernamePasswordAuthenticationToken userPassAuthToken=new UsernamePasswordAuthenticationToken(
     userDetails.getUsername(),userDetails.getPassword(),userDetails.getAuthorities());
     userPassAuthToken.setDetails(request);

     SecurityContextHolder.getContext().setAuthentication(userPassAuthToken);

//filter(request,response);

         }      }

     filterChain.doFilter(request, response);    
}

     
}