package hu.cs.onlineshop.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"})
public class Type {
 
    private String type;
    private String img;

    private List<Product> products;
 
   

    @OneToMany(mappedBy = "type",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    } 

    @Id
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
}
