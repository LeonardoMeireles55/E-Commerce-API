package com.leonardo.ecommerce.service.ecommerce;

import com.leonardo.ecommerce.domain.ecommerce.Orders;
import com.leonardo.ecommerce.repository.ecommerce.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrdersService {

    private final OrdersRepository ordersRepository;

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public List<Orders> getAllOrdersByUserId(Long id) {
        return ordersRepository.findAllByUserId(id);
    }

    public Optional<Orders> getOrderById(Long id) {
        return ordersRepository.findById(id);
    }

    public Orders createOrder(Orders order) {
        return ordersRepository.save(order);
    }

    public Orders updateOrder(Long orderId, Orders updatedOrder) {
        Orders existingOrder = ordersRepository.getReferenceById(orderId);

        existingOrder.setStatus(updatedOrder.getStatus());


        return ordersRepository.save(existingOrder);
    }

    public void deleteOrderById(Long orderId) {
        ordersRepository.deleteById(orderId);
    }
}
