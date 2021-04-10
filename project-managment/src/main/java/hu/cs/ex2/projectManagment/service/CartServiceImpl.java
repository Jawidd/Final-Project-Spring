package hu.cs.ex2.projectManagment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.cs.ex2.projectManagment.model.Cart;
import hu.cs.ex2.projectManagment.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart addCart(Cart cart) {
        
        return cartRepository.save(cart);
    }

    @Override
    public List<Cart> getAllCarts() {
    
        return cartRepository.findAll();
    }

    @Override
    public Cart getCartById(Integer id) {
        
        return cartRepository.getOne(id);
    }

   
    


    
}
