package hu.cs.onlineshop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.cs.onlineshop.dto.CartDTO;
import hu.cs.onlineshop.model.Cart;
import hu.cs.onlineshop.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ModelMapper modelMapper;

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

    @Override
    public List<CartDTO> convertToDTO(List<Cart> carts) {
        
        List<CartDTO> cartDTOList=new ArrayList<>();

        for(Cart cart:carts){
            CartDTO cartDTO =modelMapper.map(cart, CartDTO.class);
            
            cartDTO.setProductsIds(cart.getProducts().stream().map(prod->prod.getId()).collect(Collectors.toList()));
            
            cartDTOList.add(cartDTO);
        }
        
        return cartDTOList;
        
    }

    @Override
    public CartDTO convertToDTO(Cart cart) {
        CartDTO cartDTO=modelMapper.map(cart,CartDTO.class);

        cartDTO.setProductsIds(cart.getProducts().stream().map(prod->prod.getId()).collect(Collectors.toList()));
        cartDTO.setProductsNames(cart.getProducts().stream().map(prod->prod.getName()).collect(Collectors.toList()));
        return cartDTO; 
    }

   
    


    
}
