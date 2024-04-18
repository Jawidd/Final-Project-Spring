package hu.cs.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.cs.onlineshop.model.Cart;


@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
    
}
