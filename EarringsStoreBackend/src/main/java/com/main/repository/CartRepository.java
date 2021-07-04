package com.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.main.model.CartItemModel;
import com.main.model.EarringsModel;
import com.main.model.ItemModel;
import com.main.model.UserModel;

@Repository
public interface CartRepository extends JpaRepository<CartItemModel, Long> {

//	CartModel findByID(Long id);
}
