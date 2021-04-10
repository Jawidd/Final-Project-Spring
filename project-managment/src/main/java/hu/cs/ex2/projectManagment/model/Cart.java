package hu.cs.ex2.projectManagment.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Cart {

   
private Integer id;
private Integer total;
private Integer numberOfProducts;
private Invoice invoice;

private List<Product> products;
//private Date creationDate;
//private Date modificationDate;
//private Integer price;

@OneToMany
public List<Product> getProducts() {
    return products;
}

public void setProducts(List<Product> products) {
    this.products = products;
}

@OneToOne
public Invoice getInvoice() {
    return invoice;
}

public void setInvoice(Invoice invoice) {
    this.invoice = invoice;
}




@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public Integer getTotal() {
    return total;
}

public void setTotal(Integer total) {
    this.total = total;
}

public Integer getNumberOfProducts() {
    return numberOfProducts;
}

public void setNumberOfProducts(Integer numberOfProducts) {
    this.numberOfProducts = numberOfProducts;
}


    
}
