// package com.kifiya.dto;

// import lombok.Data;
// import javax.validation.constraints.NotBlank;
// import javax.validation.constraints.Size;

// @Data
// public class ResetPasswordRequest {
//     @NotBlank(message = "Token is required")
//     private String token;
    
//     @NotBlank(message = "New password is required")
//     @Size(min = 6, message = "Password must be at least 6 characters")
//     private String newPassword;
    
//     @NotBlank(message = "Confirm password is required")
//     private String confirmNewPassword;
// }
package com.kifiya.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
public class ResetPasswordRequest {// package com.kifiya.service;

    // import com.kifiya.dto.OrderDto;
    // import com.kifiya.dto.OrderItemDto;
    // import com.kifiya.model.Order;
    // import com.kifiya.model.OrderItem;
    // import com.kifiya.model.User;
    // import com.kifiya.model.Cafe;
    // import com.kifiya.repository.OrderRepository;
    // import com.kifiya.repository.UserRepository;
    // import com.kifiya.repository.CafeRepository;
    // import org.springframework.beans.factory.annotation.Autowired;
    // import org.springframework.stereotype.Service;
    // import org.springframework.transaction.annotation.Transactional;
    
    // import java.util.ArrayList;
    // import java.util.List;
    // import java.util.stream.Collectors;
    
    // @Service
    // @Transactional
    // public class OrderService {
        
    //     @Autowired
    //     private OrderRepository orderRepository;
        
    //     @Autowired
    //     private UserRepository userRepository;
        
    //     @Autowired
    //     private CafeRepository cafeRepository;
        
    //     // Create operation
    //     public OrderDto createOrder(OrderDto orderDto) {
    //         User user = userRepository.findById(orderDto.getUserId())
    //                 .orElseThrow(() -> new RuntimeException("User not found"));
            
    //         Cafe cafe = cafeRepository.findById(orderDto.getCafeId())
    //                 .orElseThrow(() -> new RuntimeException("Cafe not found"));
            
    //         Order order = new Order();
    //         order.setUser(user);
    //         order.setCafe(cafe);
    //         order.setTotalAmount(orderDto.getTotalAmount());
    //         order.setStatus(orderDto.getStatus());
    //         // order.setTotalItems(orderDto.getTotalItems());
    //         order.setIsAvailable(orderDto.getIsAvailable());
    //         order.setIsVegetarian(orderDto.getIsVegetarian());
    //         order.setIsSeasonal(orderDto.getIsSeasonal());
    //         order.setPaymentMethod(orderDto.getPaymentMethod());
            
    //         // Set delivery address if provided
    //         if (orderDto.getDeliveryAddress() != null) {
    //             //Address address = new Address();
    //             // Set address fields from DTO
    //             //order.setDeliveryAddress(address);
    //         }
            
    //         // Convert DTO items to OrderItems
    //         List<OrderItem> orderItems = new ArrayList<>();
    //         if (orderDto.getItems() != null) {
    //             for (OrderItemDto itemDto : orderDto.getItems()) {
    //                 OrderItem item = new OrderItem();
    //                 // Set item fields from DTO
    //                 item.setOrder(order);
    //                 orderItems.add(item);
    //             }
    //         }
    //         order.setItems(orderItems);
            
    //         Order savedOrder = orderRepository.save(order);
    //         return mapToDto(savedOrder);
    //     }
        
    //     // Read operation
    //     public OrderDto getOrderById(Long id) {
    //         Order order = orderRepository.findById(id)
    //                 .orElseThrow(() -> new RuntimeException("Order not found"));
    //         return mapToDto(order);
    //     }
        
    //     // Read all orders
    //     public List<OrderDto> getAllOrders() {
    //         return orderRepository.findAll()
    //                 .stream()
    //                 .map(this::mapToDto)
    //                 .collect(Collectors.toList());
    //     }
        
    //     // Update operation
    //     public OrderDto updateOrder(Long id, OrderDto orderDto) {
    //         Order existingOrder = orderRepository.findById(id)
    //                 .orElseThrow(() -> new RuntimeException("Order not found"));
            
    //         // Update fields from DTO
    //         existingOrder.setStatus(orderDto.getStatus());
    //         existingOrder.setIsAvailable(orderDto.getIsAvailable());
    //         existingOrder.setIsVegetarian(orderDto.getIsVegetarian());
    //         existingOrder.setIsSeasonal(orderDto.getIsSeasonal());
            
    //         // Update delivery address if provided
    //         if (orderDto.getDeliveryAddress() != null) {
    //             // Update address fields
    //         }
            
    //         Order updatedOrder = orderRepository.save(existingOrder);
    //         return mapToDto(updatedOrder);
    //     }
        
    //     // Delete operation
    //     public void deleteOrder(Long id) {
    //         Order order = orderRepository.findById(id)
    //                 .orElseThrow(() -> new RuntimeException("Order not found"));
    //         orderRepository.delete(order);
    //     }
        
    //     // Additional query methods
    //     public List<OrderDto> getOrdersByUser(Long userId) {
    //         return orderRepository.findByUserId(userId)
    //                 .stream()
    //                 .map(this::mapToDto)
    //                 .collect(Collectors.toList());
    //     }
        
    //     public List<OrderDto> getOrdersByCafe(Long cafeId) {
    //         return orderRepository.findByCafeId(cafeId)
    //                 .stream()
    //                 .map(this::mapToDto)
    //                 .collect(Collectors.toList());
    //     }
        
    //     public List<OrderDto> getOrdersByStatus(String status) {
    //         return orderRepository.findByStatus(status)
    //                 .stream()
    //                 .map(this::mapToDto)
    //                 .collect(Collectors.toList());
    //     }
        
    //     // Helper method to map entity to DTO
    //     private OrderDto mapToDto(Order order) {
    //         OrderDto dto = new OrderDto();
    //         dto.setId(order.getId());
    //         dto.setUserId(order.getUser().getId());
    //         dto.setCafeId(order.getCafe().getId());
    //         dto.setTotalAmount(order.getTotalAmount());
    //         dto.setStatus(order.getStatus());
    //         dto.setCreatedAt(order.getCreatedAt());
    //         dto.setItems(order.getTotalItems());
    //         dto.setIsAvailable(order.getIsAvailable());
    //         dto.setIsVegetarian(order.getIsVegetarian());
    //         dto.setIsSeasonal(order.getIsSeasonal());
    //         dto.setPaymentMethod(order.getPaymentMethod());
            
    //         if (order.getDeliveryAddress() != null) {
    //             dto.setDeliveryAddress(order.getDeliveryAddress().toString());
    //         }
            
    //         if (order.getItems() != null) {
    //             List<OrderItemDto> itemDtos = order.getItems().stream()
    //                     .map(item -> {
    //                         OrderItemDto itemDto = new OrderItemDto();
    //                         // Map item fields
    //                         return itemDto;
    //                     })
    //                     .collect(Collectors.toList());
    //             dto.setItems(itemDtos);
    //         }
            
    //         return dto;
    //     }
    // }
    
    @NotBlank(message = "Token is required")
    private String token;
    
    @NotBlank(message = "New password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String newPassword;
    
    @NotBlank(message = "Confirm password is required")
    private String confirmPassword;
}