package kom.learn.order_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ORDER_TB")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int quantity;
    private double pricePerItem;
    private double totalPrice;
}
