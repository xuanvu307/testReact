package com.example.shoppingcartbackend.repository;

import com.example.shoppingcartbackend.db.CategoryDB;
import com.example.shoppingcartbackend.exception.BadRequestException;
import com.example.shoppingcartbackend.exception.NotFoundException;
import com.example.shoppingcartbackend.model.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepository {

    public List<Category> getAllCategory() {
        return CategoryDB.categories;
    }

    public Category getCategoryById(Integer id) {
        return CategoryDB.categories.stream()
                .filter(category ->
                        category.getId().equals(id)
                )
                .findFirst()
                .orElseThrow(() -> {
                    throw new NotFoundException("Id không tồn tại");
                });
    }
}
