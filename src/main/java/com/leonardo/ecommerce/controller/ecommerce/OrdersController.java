package com.leonardo.ecommerce.controller.ecommerce;

import com.leonardo.ecommerce.domain.ecommerce.Orders;
import com.leonardo.ecommerce.service.ecommerce.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersService ordersService;

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<Orders>> getAllOrders() {
        List<Orders> orders = ordersService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
    @GetMapping("/getAllOrdersByUserId/{id}")
    public ResponseEntity<List<Orders>> getAllOrdersByUserId(@PathVariable Long id) {
        List<Orders> orders = ordersService.getAllOrdersByUserId(id);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Long id) {
        return ordersService.getOrderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Orders> createOrder(@RequestBody Orders order) {
        Orders createdOrder = ordersService.createOrder(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orders> updateOrder(@PathVariable Long id, @RequestBody Orders updatedOrder) {
        return ordersService.getOrderById(id)
                .map(existingOrder -> {
                    Orders updated = ordersService.updateOrder(id, updatedOrder);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderById(@PathVariable Long id) {
        ordersService.deleteOrderById(id);
        return ResponseEntity.noContent().build();
    }
}
