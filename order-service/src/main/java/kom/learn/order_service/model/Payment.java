package kom.learn.order_service.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Payment {
    private int paymentId;
    private String paymentStatus;
    private String  transactionId;
    private int orderId;
    private double amount;
    private String paymentMode;
    private String currency;
}
