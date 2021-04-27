package hu.cs.onlineshop.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"})
public class Customer {

    private Integer id;
    private String name;
    @Column(unique = true)
    private String username;
    private Date dateOfBirth;
    private String email;
    private String password;
    private String location;
    private boolean isAdmin;
    private Long phoneNumber;
    //private Date creationDate;
    //private Date modificationDate;

    private List<Invoice> invoices; 

   
    @OneToMany(mappedBy = "customer",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    public List<Invoice> getInvoices() {
        return invoices;
    }
 
    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    } 
    


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Customer(Integer id, String name, String username, Date dateOfBirth, String email, String password,
            String location, boolean isAdmin, Long phoneNumber, List<Invoice> invoices) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
        this.location = location;
        this.isAdmin = isAdmin;
        this.phoneNumber = phoneNumber;
        this.invoices = invoices;
    }

    public Customer() {
    }

    public Customer(Integer id, String username, String password, boolean isAdmin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

   

    
}
