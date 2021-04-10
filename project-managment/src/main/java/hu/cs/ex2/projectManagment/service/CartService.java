
 package hu.cs.ex2.projectManagment.service;

 import java.util.List;

import hu.cs.ex2.projectManagment.model.Cart;
 
 public interface CartService {
     public Cart addCart(Cart cart);
    
     public List<Cart> getAllCarts();
    
     public Cart   getCartById(Integer id);  
 
     //public void deleteCartById(Integer id);
 

 }
 
 
 