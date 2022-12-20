package lab13;

import lombok.Getter;
import lombok.Setter;

public class Product {
    @Getter

    @Setter
    private int ID;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private int cost;
    public Product(int id, String title, int cost){
        this.ID = id;
        this.title = title;
        this.cost = cost;
    }

    public Product(){
    }
}
