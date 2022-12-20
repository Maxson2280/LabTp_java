package lab13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[]args){
        ApplicationContext a = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductService p = a.getBean(ProductService.class);
        p.printAll();
        Cart q = a.getBean(Cart.class);
        q.add("Хлеб");
        q.add("Йогурт");
        OrderService o = a.getBean(OrderService.class);
        o.form();
    }
}
