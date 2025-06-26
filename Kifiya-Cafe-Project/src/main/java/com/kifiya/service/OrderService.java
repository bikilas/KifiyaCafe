package com.kifiya.service;

import com.kifiya.dto.OrderDto;
import com.kifiya.dto.OrderItemDto;
import com.kifiya.model.Order;
import com.kifiya.model.OrderItem;
import com.kifiya.model.User;
import com.kifiya.model.Cafe;
import com.kifiya.repository.OrderRepository;
import com.kifiya.repository.UserRepository;
import com.kifiya.repository.CafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CafeRepository cafeRepository;
    
    // Create operation
    public OrderDto createOrder(OrderDto orderDto) {
        User user = userRepository.findById(orderDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + orderDto.getUserId()));
        
        Cafe cafe = cafeRepository.findById(orderDto.getCafeId())
                .orElseThrow(() -> new RuntimeException("Cafe not found with id: " + orderDto.getCafeId()));
        
        Order order = new Order();
        order.setUser(user);
        order.setCafe(cafe);
        order.setTotalAmount(orderDto.getTotalAmount());
        order.setStatus(orderDto.getStatus());
        order.setTotalItems(orderDto.getTotalItems());
        order.setIsAvailable(orderDto.getIsAvailable());
        order.setIsVegetarian(orderDto.getIsVegetarian());
        order.setIsSeasonal(orderDto.getIsSeasonal());
        order.setPaymentMethod(orderDto.getPaymentMethod());
        
        // Set delivery address if provided
        if (orderDto.getDeliveryAddress() != null) {
            order.setDeliveryAddress(orderDto.getDeliveryAddress());
        }
        
        if (orderDto.getDeliveryInstructions() != null) {
            order.setDeliveryInstructions(orderDto.getDeliveryInstructions());
        }
        
        // Convert DTO items to OrderItems
        List<OrderItem> orderItems = new ArrayList<>();
        if (orderDto.getItems() != null) {
            for (OrderItemDto itemDto : orderDto.getItems()) {
                OrderItem item = new OrderItem();
                item.setOrder(order);
                item.setFoodId(itemDto.getFoodId());
                item.setFoodName(itemDto.getFoodName());
                item.setPrice(itemDto.getPrice());
                item.setQuantity(itemDto.getQuantity());
                item.setSubtotal(itemDto.getPrice().multiply(BigDecimal.valueOf(itemDto.getQuantity())));
                item.setNotes(itemDto.getNotes());
                orderItems.add(item);
            }
        }
        order.setItems(orderItems);
        
        Order savedOrder = orderRepository.save(order);
        return mapToDto(savedOrder);
    }
    
    private OrderDto mapToDto(Order savedOrder) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapToDto'");
    }

    // Read operation
    public OrderDto getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        return mapToDto(order);
    }
    
    // Read all orders
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
    
    // Update operation
    public OrderDto updateOrder(Long id, OrderDto orderDto) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        
        existingOrder.setStatus(orderDto.getStatus());
        existingOrder.setIsAvailable(orderDto.getIsAvailable());
        existingOrder.setIsVegetarian(orderDto.getIsVegetarian());
        existingOrder.setIsSeasonal(orderDto.getIsSeasonal());
        
        if (orderDto.getDeliveryAddress() != null) {
            existingOrder.setDeliveryAddress(orderDto.getDeliveryAddress());
        }
        
        if (orderDto.getDeliveryInstructions() != null) {
            existingOrder.setDeliveryInstructions(orderDto.getDeliveryInstructions());
        }
        
        // Update items if provided
        if (orderDto.getItems() != null) {
            List<OrderItem> newItems = new ArrayList<>();
            for (OrderItemDto itemDto : orderDto.getItems()) {
                OrderItem item = new OrderItem();
                item.setOrder(existingOrder);
                item.setFoodId(itemDto.getFoodId());
                item.setFoodName(itemDto.getFoodName());
                item.setPrice(itemDto.getPrice());
                item.setQuantity(itemDto.getQuantity());
                item.setSubtotal(itemDto.getPrice().multiply(BigDecimal.valueOf(itemDto.getQuantity())));
                item.setNotes(itemDto.getNotes());
                newItems.add(item);
            }
            existingOrder.setItems(newItems);
        }
        
        Order updatedOrder = orderRepository.save(existingOrder);
        return mapToDto(updatedOrder);
    }
    
    // Delete operation
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        orderRepository.delete(order);
    }
    
    // Additional query methods
    public List<OrderDto> getOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
    
    public List<OrderDto> getOrdersByCafe(Long cafeId) {
        return orderRepository.findByCafeId(cafeId)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
    
    public List<OrderDto> getOrdersByStatus(String status) {
        return orderRepository.findByStatus(status)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
}   