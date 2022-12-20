package lab13;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductService {
    private List<Product> products;

    public ProductService() {
    }

    @PostConstruct
    private void post() {
        products = new ArrayList<>();
        products.addAll(List.of(new Product[]{
                new Product(1, "Хлеб", 25),
                new Product(2, "Масло", 125),
                new Product(3, "Колбаса", 200),
                new Product(4, "Вода", 30),
                new Product(5, "Йогурт", 50),
                new Product(6, "Яйца", 60),
                new Product(7, "Огурцы", 100),
                new Product(8, "Лук", 70),
                new Product(9, "Дыня", 75),
                new Product(10, "Сыр", 60000),
        }));
    }

    public void printAll() {
        for (Product p :
                products) {
            System.out.println(p.getTitle() + ": " + p.getCost());
        }
    }

    public Product findByTitle(String title) {
        return products.stream().filter(p -> p.getTitle().equals(title)).findFirst().get();
    }
}
