
 package hu.cs.ex2.projectManagment.service;

 import java.util.List;

import hu.cs.ex2.projectManagment.model.Product;

 
 public interface ProductService {
     public Product addProduct(Product user);
    
     public List<Product> getAllProducts();
    
     public Product   getProductById(Integer id);  
 
     //public void deleteProductById(Integer id);
 
 
 }
 
 
 