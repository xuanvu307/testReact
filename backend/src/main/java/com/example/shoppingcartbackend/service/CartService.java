package com.example.shoppingcartbackend.service;

import com.example.shoppingcartbackend.dto.CartItemDto;
import com.example.shoppingcartbackend.exception.BadRequestException;
import com.example.shoppingcartbackend.mapper.CartMapper;
import com.example.shoppingcartbackend.model.CartItem;
import com.example.shoppingcartbackend.repository.CartItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CartService {


    @Autowired
    private final CartMapper cartMapper;
    private final CartItemRepository cartItemRepository;

    public List<CartItemDto> getListCard() {
        return cartMapper.getAllCartDto();
    }

    public void deleteItem(Integer id) {
        cartItemRepository.getListCart().removeIf(cartItem -> Objects.equals(cartItem.getId(), id));
    }

    public void incrementItem(Integer id) {
        CartItem cartItem = cartItemRepository.getCartById(id);
        cartItem.setCount(cartItem.getCount() + 1);
    }

    public void decrementItem(Integer id) {
        CartItem cartItem = cartItemRepository.getCartById(id);
        if (cartItem.getCount() > 1) {
            cartItem.setCount(cartItem.getCount() - 1);
        } else {
            throw new BadRequestException("không thể giảm sản phẩm");
        }
    }
}
