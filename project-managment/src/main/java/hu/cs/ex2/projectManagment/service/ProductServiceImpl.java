package hu.cs.ex2.projectManagment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.cs.ex2.projectManagment.model.Product;
import hu.cs.ex2.projectManagment.repository.ProductRepository;

/**
 * ProductServiceImpl
 */

 @Service
public class ProductServiceImpl implements ProductService {

@Autowired
ProductRepository productRepository;


    @Override
    public Product addProduct(Product user) {
        return productRepository.save(user);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.getOne(id);
    }
    

    
}