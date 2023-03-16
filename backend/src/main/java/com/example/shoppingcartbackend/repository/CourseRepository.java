package com.example.shoppingcartbackend.repository;

import com.example.shoppingcartbackend.db.CategoryDB;
import com.example.shoppingcartbackend.db.CourseDB;
import com.example.shoppingcartbackend.exception.NotFoundException;
import com.example.shoppingcartbackend.model.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepository {

    public List<Course> getAllCourse() {
        return CourseDB.courses;
    }

    public Course getCourseById(Integer id) {
        return CourseDB.courses.stream()
                .filter(course -> course.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> {
                    throw new NotFoundException("Id không tồn tại");
                });
    }
}
