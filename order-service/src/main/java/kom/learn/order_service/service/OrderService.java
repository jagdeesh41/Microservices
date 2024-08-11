package kom.learn.order_service.service;

import kom.learn.order_service.entity.Order;
import kom.learn.order_service.model.Payment;
import kom.learn.order_service.model.TransactionData;
import kom.learn.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;
    public TransactionData saveOrder(TransactionData transactionData)
    {
        Order order=transactionData.getOrder();
        Payment payment=transactionData.getPayment();
        log.info("Before Order-service invoked! {}",payment);
        order.setTotalPrice(order.getQuantity() * order.getPricePerItem());
        // time to process payment
        Order savedOrder=orderRepository.save(order);
        //post call via rest template
        payment.setOrderId(savedOrder.getId());
        payment.setAmount(savedOrder.getTotalPrice());
        log.info("After Order-service invoked! {}",payment);
        Payment orderResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment",payment,Payment.class);
        return new TransactionData(savedOrder,orderResponse);


    }

    public Order getOrderById(int orderId)
    {
        return orderRepository.findById(orderId).orElse(null);
    }

    public Payment getPaymentHistoryByOrderId(int orderId)
    {
        Map<String,Integer > pathVariables=new HashMap<>(Map.of("orderId",orderId));

        return restTemplate.getForObject("http://PAYMENT-SERVICE/payment/history/"+"{orderId}"
                ,Payment.class
                ,pathVariables);
    }


}
