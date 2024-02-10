package com.leonardo.ecommerce.controller.ecommerce;

import com.leonardo.ecommerce.domain.ecommerce.OrderItem;
import com.leonardo.ecommerce.record.ecommerce.OrderItemDTO;
import com.leonardo.ecommerce.record.ecommerce.OrderItemNoWithUnitPriceDTO;
import com.leonardo.ecommerce.service.ecommerce.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orderItem")
@RequiredArgsConstructor
public class OrderItemController {

    private final OrderItemService orderItemService;

    @GetMapping("/getAllOrdersItem")
    public ResponseEntity<List<OrderItemDTO>> getAllOrderItems() {
        List<OrderItemDTO> orderItems = orderItemService.getAllOrderItems().stream()
                .map(orderItem -> new OrderItemDTO(orderItem.getId(), orderItem.getQuantity(),
                        orderItem.getUnitPrice(),orderItem.getProductId(),orderItem.getOrderId()))
                .toList();
        return ResponseEntity.ok(orderItems);
    }

    @GetMapping("/getAllOrdersItemByOrderId")
    public ResponseEntity<List<OrderItemDTO>> getAllOrderItemsByOrderId(Long id) {
        List<OrderItemDTO> orderItems = orderItemService.getAllOrderItemsByOrderId(id).stream()
                .map(orderItem -> new OrderItemDTO(orderItem.getId(), orderItem.getQuantity(),
                        orderItem.getUnitPrice(),orderItem.getProductId(),orderItem.getOrderId()))
                .toList();
        return ResponseEntity.ok(orderItems);
    }

    @GetMapping("getOrderItemById/{id}")
    public Optional<OrderItem> getOrderItemById(@PathVariable Long id) {
        return orderItemService.getOrderItemById(id);
    }

    @PostMapping("/postOrderItem")
    public ResponseEntity<OrderItem> saveOrderItem(@RequestBody OrderItemNoWithUnitPriceDTO orderItemDTO) {
        OrderItem createdOrderItem = orderItemService.saveOrderItem(orderItemDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderItem);
    }

    @DeleteMapping("deleteOrderItemById/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
        orderItemService.deleteOrderItem(id);
        return ResponseEntity.noContent().build();
    }
}
