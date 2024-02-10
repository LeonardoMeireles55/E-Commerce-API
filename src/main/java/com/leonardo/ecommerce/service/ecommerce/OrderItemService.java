package com.leonardo.ecommerce.service.ecommerce;

import com.leonardo.ecommerce.domain.ecommerce.OrderItem;
import com.leonardo.ecommerce.record.ecommerce.OrderItemNoWithUnitPriceDTO;
import com.leonardo.ecommerce.repository.ecommerce.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final ProductService productService;

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public List<OrderItem> getAllOrderItemsByOrderId(Long id) {
        return orderItemRepository.findAllByOrderId(id);
    }

    public Optional<OrderItem> getOrderItemById(Long id) {
        return orderItemRepository.findById(id);
    }

    public OrderItem saveOrderItem(OrderItemNoWithUnitPriceDTO orderItemDTO) {
        var finalPrice = productService.getPriceById(orderItemDTO.productId()) * orderItemDTO.quantity();
        var order = new OrderItem(orderItemDTO.quantity(), orderItemDTO.productId(), orderItemDTO.orderId(), finalPrice);
        return orderItemRepository.save(order);
    }

    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
}