package lab13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private Cart cart;

    @Autowired
    public void setCart(Cart c){
        this.cart = c;
    }

    public void form(){
        System.out.println("\nВаши покупки:");
        int sum = 0;
        for (Product p: cart.getProducts()) {
            System.out.println(p.getTitle());
            sum+=p.getCost();
        }
        System.out.println("Итоговая стоимость: "+ sum);
    }
}
