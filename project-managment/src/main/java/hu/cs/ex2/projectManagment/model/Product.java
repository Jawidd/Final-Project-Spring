package hu.cs.ex2.projectManagment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"})
public class Product {



    private Integer id;
    private String name;
    private Integer price;
    private Integer quantity;
    
    private String details;
    private String img;
    //private boolean deleted; 
    //private String barcode;
    //private Date creationDate;
    //private Date modificationDate;
    private Cart cart;
    private Type type;
   
   /*  @Transient
    @JsonInclude 
    private String typeString; */
 

    @ManyToOne()
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
     this.type = type;
      
      
    }


   
    
    
    @ManyToOne
    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }





    
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

   


    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

 

    
}
