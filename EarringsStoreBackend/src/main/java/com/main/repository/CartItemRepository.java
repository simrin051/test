package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.model.CartItemModel;

@Repository
public interface CartItemRepository extends JpaRepository<CartItemModel, Long> {

}
