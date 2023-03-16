package com.example.shoppingcartbackend.dto;

import com.example.shoppingcartbackend.model.Category;
import com.example.shoppingcartbackend.model.User;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CourseDto {
    private Integer id;
    private String name;
    private String description;
    private String type;
    private List<Category> categories;
    private String thumbnail;
    private Integer price;
    private Double rating;
    private User user;
}
