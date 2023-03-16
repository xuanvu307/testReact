package com.example.shoppingcartbackend.db;

import com.example.shoppingcartbackend.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
    public static List<User> users = new ArrayList<>(List.of(
            new User(1, "Nguyễn Văn A","a@gmail.com","0123456789","avatar"),
            new User(2, "Nguyễn Văn B","b@gmail.com","0123456789","avatar"),
            new User(3, "Nguyễn Văn C","c@gmail.com","0123456789","avatar"),
            new User(4, "Nguyễn Văn D","d@gmail.com","0123456789","avatar")
    ));
}
