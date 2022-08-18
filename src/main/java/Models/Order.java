package Models;

import lombok.Data;

@Data
public class Order extends Product{
    private int orderId;
    private int uid;
    private int quantity;
    private String date;
}
