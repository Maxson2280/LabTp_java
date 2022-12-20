package lab13;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
    private ProductService productService;
    @Getter
    private final List<Product> products;

    @Autowired
    public void setProductService(ProductService p){
        this.productService = p;
    }

    public Cart(){
        products = new ArrayList<>();
    }

    public void add(String title){
        products.add(productService.findByTitle(title));
    }
}