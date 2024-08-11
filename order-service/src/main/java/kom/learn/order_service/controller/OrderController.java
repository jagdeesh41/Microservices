package kom.learn.order_service.controller;

import kom.learn.order_service.entity.Order;
import kom.learn.order_service.model.Payment;
import kom.learn.order_service.model.TransactionData;
import kom.learn.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    @PostMapping("/bookOrder")
    public TransactionData bookOrder(@RequestBody TransactionData data)
    {
        return orderService.saveOrder(data);
    }
    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable("orderId") int orderId)
    {
        return orderService.getOrderById(orderId);
    }
    @GetMapping("/history/{orderId}")
    public Payment getPaymentHistoryByOrderId(@PathVariable("orderId") int orderId)
    {
        return orderService.getPaymentHistoryByOrderId(orderId);

    }
}
