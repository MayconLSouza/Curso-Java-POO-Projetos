package com.mayconlsouza.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayconlsouza.course.entities.OrderItem;
import com.mayconlsouza.course.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{


}
