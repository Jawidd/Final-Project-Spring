package hu.cs.ex2.projectManagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.cs.ex2.projectManagment.model.Product;



@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
  
    

}
