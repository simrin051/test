package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.model.CartItemModel;
//import com.main.model.CartModel;

@Repository
public interface OrdersRepository extends JpaRepository<CartItemModel, Long> {



}
