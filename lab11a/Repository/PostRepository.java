package com.example.lab11a.Repository;

import com.example.lab11a.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
    Post findPostById(Integer id);

    List<Post> findPostByUserid(Integer userid);

    List<Post> findPostByTitle(String title);

    List<Post> findPostByPublishDateBefore(LocalDate publishDate);



}
