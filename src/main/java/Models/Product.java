package Models;

import lombok.Data;

@Data
public class Product {
    private int id;
    private String name;
    private String category;
    private double price;
    private String image;

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price='" + price + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
