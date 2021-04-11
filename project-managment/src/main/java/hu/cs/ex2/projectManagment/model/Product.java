package hu.cs.ex2.projectManagment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"})
public class Product {

    private Integer id;
    private String name;
    private Integer price;
    private Integer qunatity;
    //private boolean deleted;
    //private String barcode;
    //private Date creationDate;
    //private Date modificationDate;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQunatity() {
        return qunatity;
    }

    public void setQunatity(Integer qunatity) {
        this.qunatity = qunatity;
    }
   

    
}
