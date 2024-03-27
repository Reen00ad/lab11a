package com.example.lab11a.Repository;

import com.example.lab11a.Model.Category;
import com.example.lab11a.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Category findCategoryById(Integer id);

    @Query("select c from Category c where c.name like ?1%")
    List<Category> names(String  ch);
}
