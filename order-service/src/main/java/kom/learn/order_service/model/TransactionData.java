package kom.learn.order_service.model;

import kom.learn.order_service.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionData {
    private Order order;
    private Payment payment;

}
