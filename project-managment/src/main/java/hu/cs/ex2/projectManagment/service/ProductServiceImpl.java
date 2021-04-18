package hu.cs.ex2.projectManagment.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.cs.ex2.projectManagment.dto.ProductDTO;

import hu.cs.ex2.projectManagment.model.Product;

import hu.cs.ex2.projectManagment.repository.ProductRepository;

/**
 * ProductServiceImpl
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ModelMapper modelmapper;

    @Override
    public Product addProduct(Product user) {
        return productRepository.save(user);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // ......
    /*
     * @Override public List<Product> getAllProductsByCartId(Integer cartId) {
     * 
     * Cart cart=cartRepository.getOne(cartId);
     * productRepository.findAll().stream().filter(prod->prod.getCart()==cart);
     * return null; }
     */

    @Override
    public Product getProductById(Integer id) {
        return productRepository.getOne(id);
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> convertToDTO(List<Product> products) {

        List<ProductDTO> productDTOs = new ArrayList<>();

        for (Product product : products) {
            ProductDTO productDTO = modelmapper.map(product, ProductDTO.class);
            productDTOs.add(productDTO);

        }

        return productDTOs;
    }

    @Override
    public ProductDTO convertToDTO(Product product) {

        return modelmapper.map(product, ProductDTO.class);
    }

    @Override
    public void deleteProductById(Integer id) {
       productRepository.deleteById(id);

    }

  

   /*  @Override
    public List<Product> getProductsByType(String type) {
        
        //List<Product> pl=productRepository.findAll().stream().filter(prod->prod.getType().equalsIgnoreCase(type)).collect(Collectors.toList());
        //List <Product> a=productRepository.findAll().stream().filter(prod->prod.getType().compareToIgnoreCase(type)==1).collect(Collectors.toList());
        Product b=productRepository.getOne(23);
        List <Product> a=productRepository.findAll();
        return a;
    } */
    

    
}