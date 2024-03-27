package com.example.lab11a.Repository;

import com.example.lab11a.Model.Comment;
import com.example.lab11a.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
    Comment findCommentById(Integer id);

    List<Comment> findCommentByPostid(Integer postid);

    List<Comment> findCommentByPostidAndUserid(Integer postid,Integer userid);

    @Query("select c from Comment c where c.commentDate=?1")
    List<Comment> findcomment(LocalDate date1);


}
