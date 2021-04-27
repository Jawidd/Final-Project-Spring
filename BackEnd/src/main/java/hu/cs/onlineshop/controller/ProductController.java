package hu.cs.onlineshop.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.cs.onlineshop.dto.ProductDTO;
import hu.cs.onlineshop.model.Product;

import hu.cs.onlineshop.service.ProductService;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {
      
    @Autowired
    ProductService productservice;

    @Autowired
    ModelMapper modelMapper;

     @GetMapping("/product/{id}/getOne")
     public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id){
       
        return new ResponseEntity<>(productservice.convertToDTO(productservice.getProductById(id)),HttpStatus.OK);

     }







  /*   @Autowired
    TypeService typeService; */
   
    @PostMapping("/productDTO/add")
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO productDTO){
   
      Product a=modelMapper.map(productDTO,Product.class);

      
       ProductDTO productDTO2=productservice.convertToDTO(productservice.addProduct(a));
       return new ResponseEntity<>(productDTO2,HttpStatus.CREATED);
    }




    @PostMapping("/product/add")
     public ResponseEntity<ProductDTO> saveProduct(@RequestBody Product product){
    
        ProductDTO productDTO=productservice.convertToDTO(productservice.addProduct(product));
        return new ResponseEntity<>(productDTO,HttpStatus.CREATED);
     }


    @GetMapping("/product/getAll")
     public ResponseEntity<List<ProductDTO>> getAllProducts(){
     
        return new ResponseEntity<>(productservice.convertToDTO(productservice.getAllProducts()),HttpStatus.OK);
     }

    


   
    
    @PutMapping("product/update")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody Product product){
    
        ProductDTO productDTO=productservice.convertToDTO(productservice.addProduct(product));
         return new ResponseEntity<>(productDTO,HttpStatus.CREATED);
      }
 
 
      @PutMapping("productDTO/update")
      public ResponseEntity<ProductDTO> updateProductDTO(@RequestBody ProductDTO productDTO){
      
         Product a=modelMapper.map(productDTO,Product.class);

      
         ProductDTO productDTO2=productservice.convertToDTO(productservice.addProduct(a));
         return new ResponseEntity<>(productDTO2,HttpStatus.OK);
        }
    

      @DeleteMapping("/product/{id}/delete")
     public void deleteProductById(@PathVariable Integer id){
       productservice.deleteProductById(id);
        
       
     /* @GetMapping("/product/{type}/getAll")
     public ResponseEntity<List<ProductDTO>> getProductsByType(@PathVariable String type){
     
        return new ResponseEntity<>(productservice.convertToDTO(productservice.getProductsByType(type)),HttpStatus.OK);
     } */

     }
}
