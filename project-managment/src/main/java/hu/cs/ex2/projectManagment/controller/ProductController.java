package hu.cs.ex2.projectManagment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import hu.cs.ex2.projectManagment.dto.ProductDTO;
import hu.cs.ex2.projectManagment.model.Product;
import hu.cs.ex2.projectManagment.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {
      
    @Autowired
    ProductService productservice;
    
 
    @PostMapping("/product/add")
     public ResponseEntity<ProductDTO> saveProduct(@RequestBody Product product){
    
        ProductDTO productDTO=productservice.convertToDTO(productservice.addProduct(product));
        return new ResponseEntity<>(productDTO,HttpStatus.CREATED);
     }


    @GetMapping("/product/getAll")
     public ResponseEntity<List<ProductDTO>> getAllProducts(){
     
        return new ResponseEntity<>(productservice.convertToDTO(productservice.getAllProducts()),HttpStatus.OK);
     }

    

     /* @GetMapping("/product/{type}/getAll")
     public ResponseEntity<List<ProductDTO>> getProductsByType(@PathVariable String type){
     
        return new ResponseEntity<>(productservice.convertToDTO(productservice.getProductsByType(type)),HttpStatus.OK);
     } */

    @GetMapping("/product/{id}/getOne")
     public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id){
       
        return new ResponseEntity<>(productservice.convertToDTO(productservice.getProductById(id)),HttpStatus.OK);

     }

   
    
    @PutMapping("product/update")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody Product product){
    
        ProductDTO productDTO=productservice.convertToDTO(productservice.addProduct(product));
         return new ResponseEntity<>(productDTO,HttpStatus.CREATED);
      }
 
      

      @DeleteMapping("/product/{id}/delete")
     public void deleteProductById(@PathVariable Integer id){
       productservice.deleteProductById(id);
        

     }
}
