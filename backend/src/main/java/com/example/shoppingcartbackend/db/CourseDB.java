package com.example.shoppingcartbackend.db;

import com.example.shoppingcartbackend.model.Category;
import com.example.shoppingcartbackend.model.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseDB {
    public static List<Course> courses = new ArrayList<>(List.of(
            new Course(1,"Bài học 1","Mô tả","TYPE",List.of(CategoryDB.categories.get(1), CategoryDB.categories.get(2)),"thumbnail",12_300_000,4.0,1),
            new Course(2,"Bài học 2","Mô tả","TYPE",List.of(CategoryDB.categories.get(1),CategoryDB.categories.get(3)),"thumbnail",30_000_000,4.0,2),
            new Course(3,"Bài học 3","Mô tả","TYPE",List.of(CategoryDB.categories.get(1),CategoryDB.categories.get(5),CategoryDB.categories.get(6)),"thumbnail",23_000_000,4.0,3),
            new Course(4,"Bài học 4","Mô tả","TYPE",List.of(CategoryDB.categories.get(1),CategoryDB.categories.get(0)),"thumbnail",10_000_000,4.0,4),
            new Course(5,"Bài học 5","Mô tả","TYPE",List.of(CategoryDB.categories.get(1),CategoryDB.categories.get(4)),"thumbnail",5_000_000,4.0,2)
    ));
}
