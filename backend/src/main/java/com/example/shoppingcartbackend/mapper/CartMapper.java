package com.example.shoppingcartbackend.mapper;

import com.example.shoppingcartbackend.dto.CartItemDto;
import com.example.shoppingcartbackend.dto.CourseDto;
import com.example.shoppingcartbackend.model.CartItem;
import com.example.shoppingcartbackend.model.Course;
import com.example.shoppingcartbackend.repository.CartItemRepository;
import com.example.shoppingcartbackend.repository.CourseRepository;
import com.example.shoppingcartbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CartMapper {

    @Autowired
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final CartItemRepository cartItemRepository;

    public CartItemDto getCart(CartItem cartItem) {
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setId(cartItem.getId());
        cartItemDto.setCount(cartItem.getCount());
        Course course = courseRepository.getCourseById(cartItem.getCourseId());
        cartItemDto.setCourse(getCourseDto(course));

        return cartItemDto;
    }

    public List<CartItemDto> getAllCartDto() {
        return cartItemRepository.getListCart().stream()
                .map(this::getCart)
                .toList();
    }

    public CourseDto getCourseDto(Course course) {
        CourseDto courseDto = new CourseDto();
        courseDto.setId(course.getId());
        courseDto.setName(course.getName());
        courseDto.setDescription(course.getDescription());
        courseDto.setType(course.getType());
        courseDto.setCategories(course.getCategories());
        courseDto.setThumbnail(course.getThumbnail());
        courseDto.setPrice(course.getPrice());
        courseDto.setRating(course.getRating());
        courseDto.setUser(userRepository.getUserById(course.getUserId()));

        return courseDto;
    }
}
