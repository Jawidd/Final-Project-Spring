package hu.cs.ex2.projectManagment.dto;

import java.util.List;

public class TypeDTO {

    private String type;
    private String img;

    private List<ProductDTO> products;

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

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
    
}
