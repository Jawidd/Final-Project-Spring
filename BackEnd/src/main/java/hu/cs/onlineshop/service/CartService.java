
 package hu.cs.onlineshop.service;

 import java.util.List;

import hu.cs.onlineshop.dto.CartDTO;
import hu.cs.onlineshop.model.Cart;
 
 public interface CartService {
     public Cart addCart(Cart cart);
    
     public List<Cart> getAllCarts();
    
     public Cart   getCartById(Integer id); 
      

     public List<CartDTO> convertToDTO(List<Cart> carts);

     public CartDTO convertToDTO(Cart cart);
 
     //public void deleteCartById(Integer id);
 

 }
 
 
 