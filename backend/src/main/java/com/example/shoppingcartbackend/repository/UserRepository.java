package com.example.shoppingcartbackend.repository;

import com.example.shoppingcartbackend.db.UserDB;
import com.example.shoppingcartbackend.exception.NotFoundException;
import com.example.shoppingcartbackend.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    public List<User> getListUser() {
        return UserDB.users;
    }

    public User getUserById(Integer id) {
        return UserDB.users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> {
                    throw new NotFoundException("Id không tồn tại");
                });
    }
}
