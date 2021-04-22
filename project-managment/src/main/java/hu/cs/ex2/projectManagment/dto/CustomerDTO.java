package hu.cs.ex2.projectManagment.dto;

import java.sql.Date;
import java.util.List;

public class CustomerDTO {

    private Integer id;
    private String name;
    private String lastName;
    private Date dateOfBirth;
    private String email;
    private String password;
    private String location;
    private boolean isAdmin;
    private Long phoneNumber;
    
    
    private List<Integer> invoicesIds;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public List<Integer> getInvoicesIds() {
        return invoicesIds;
    }

    public void setInvoicesIds(List<Integer> invoicesIds) {
        this.invoicesIds = invoicesIds;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

 

    
}
