package com.example.shoppingcartbackend.controller;

import com.example.shoppingcartbackend.dto.CartItemDto;
import com.example.shoppingcartbackend.model.CartItem;
import com.example.shoppingcartbackend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CartController {


    @Autowired
    private CartService cartService;

    //    1. Lấy danh sách tất cả sản phẩm trong giỏ hàng
    @GetMapping("cartItems")
    public List<CartItemDto> getListCard() {
        return cartService.getListCard();
    }

    //2. Xóa sản phẩm trong giỏ hàng
    @DeleteMapping("cartItems/{id}")
    public void deleteItem(@PathVariable Integer id) {
        cartService.deleteItem(id);
    }

    //    3. Tăng số lượng sản phẩm trong giỏ hàng
    @PutMapping("cartItems/{id}/increment")
    public void incrementItem(@PathVariable Integer id) {
        cartService.incrementItem(id);
    }

    //    4. Giảm số lượng sản phẩm trong giỏ hàng
    @PutMapping("cartItems/{id}/decrement")
    public void decrementItem(@PathVariable Integer id) {
        cartService.decrementItem(id);
    }
}
