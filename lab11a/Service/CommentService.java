package com.example.lab11a.Service;

import com.example.lab11a.ApiResponce.ApiExeption;
import com.example.lab11a.Model.Category;
import com.example.lab11a.Model.Comment;
import com.example.lab11a.Model.Post;
import com.example.lab11a.Model.User;
import com.example.lab11a.Repository.CommentRepository;
import com.example.lab11a.Repository.PostRepository;
import com.example.lab11a.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public List<Comment> getAllComment(){
        return commentRepository.findAll();
    }

    public void addComment(Comment comment){
        User user = userRepository.findUserById(comment.getUserid());
        Post post = postRepository.findPostById(comment.getPostid());

        if(user==null ){
            if(post == null){
                throw new ApiExeption("post id not found");
            }
            throw new ApiExeption("user id not found");
        }

        comment.setCommentDate(LocalDate.now());
        commentRepository.save(comment);
    }

    public void updateComment(Integer id,Comment comment){

        Comment c=commentRepository.findCommentById(id);

        if(c==null){
            throw new ApiExeption("wrong id");

        }
        c.setUserid(comment.getUserid());
        c.setPostid(comment.getPostid());
        c.setContent(comment.getContent());
        c.setCommentDate(comment.getCommentDate());


        commentRepository.save(c);
    }

    public void deleteComment(Integer id){
        Comment c=commentRepository.findCommentById(id);
        if(c==null){
            throw new ApiExeption("wrong id");

        }
        commentRepository.delete(c);

    }

    public List<Comment> commentBypostid(Integer postid){
        List<Comment> c=commentRepository.findCommentByPostid(postid);
        if(c.isEmpty()){
            throw new ApiExeption("not found");
        }
        return c;
    }
    public List<Comment> commentBypostiduserid(Integer postid,Integer userid){
        List<Comment> c=commentRepository.findCommentByPostidAndUserid(postid,userid);
        if(c.isEmpty()){
            throw new ApiExeption("not found");
        }
        return c;
    }

    public List<Comment> commentdate(LocalDate date1){
        List<Comment> c=commentRepository.findcomment(date1);
        if(c.isEmpty()){
            throw new ApiExeption("not found");
        }
        return c;
    }



}
