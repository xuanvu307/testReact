package com.example.shoppingcartbackend.repository;

import com.example.shoppingcartbackend.db.CartDB;
import com.example.shoppingcartbackend.exception.NotFoundException;
import com.example.shoppingcartbackend.model.CartItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartItemRepository {

    public List<CartItem> getListCart() {
        return CartDB.carts;
    }

    public CartItem getCartById(Integer id) {
        return CartDB.carts.stream()
                .filter(cartItem -> cartItem.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> {
                    throw new NotFoundException("Không tìm thấy id");
                });
    }
}
