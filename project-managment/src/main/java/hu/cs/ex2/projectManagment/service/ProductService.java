
 package hu.cs.ex2.projectManagment.service;

 import java.util.List;

import hu.cs.ex2.projectManagment.dto.ProductDTO;
import hu.cs.ex2.projectManagment.model.Product;

 
 public interface ProductService {
     public Product addProduct(Product user);
    
     public List<Product> getAllProducts();

     //public List<Product> getAllProductsByCartId(Integer cartId);
    
     public Product   getProductById(Integer id); 
     
     
    
     public List<ProductDTO> convertToDTO(List<Product> products);

     public ProductDTO convertToDTO(Product product);
 
     public void deleteProductById(Integer id);

 /*     public List<Product> getProductsByType(String type); */
 
 
 }
 
 
 