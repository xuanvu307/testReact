package com.example.shoppingcartbackend.db;

import com.example.shoppingcartbackend.model.CartItem;

import java.util.ArrayList;
import java.util.List;

public class CartDB {
    public static List<CartItem> carts = new ArrayList<>(List.of(
            new CartItem(1,1,1),
            new CartItem(2,3,4),
            new CartItem(3,2,1),
            new CartItem(4,2,2),
            new CartItem(5,3,3)
    ));
}
