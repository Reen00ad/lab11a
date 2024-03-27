package com.example.lab11a.Service;

import com.example.lab11a.ApiResponce.ApiExeption;
import com.example.lab11a.Model.Category;
import com.example.lab11a.Model.Post;
import com.example.lab11a.Model.User;
import com.example.lab11a.Repository.CategoryRepository;
import com.example.lab11a.Repository.PostRepository;
import com.example.lab11a.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    public void addPost(Post post){
        User user = userRepository.findUserById(post.getUserid());
        Category category = categoryRepository.findCategoryById(post.getCategoryid());

        if(user==null ){
            if(category == null){
            throw new ApiExeption("category id not found");
        }
            throw new ApiExeption("user id not found");
        }

        post.setPublishDate(LocalDate.now());
        postRepository.save(post);
    }




    public void updatePost(Integer id,Post post){

        Post p=postRepository.findPostById(id);

        if(p==null){
            throw new ApiExeption("wrong id");

        }
        p.setCategoryid(post.getCategoryid());
        p.setTitle(post.getTitle());
        p.setContent(post.getContent());
        p.setUserid(post.getUserid());
        p.setPublishDate(post.getPublishDate());

        postRepository.save(p);
    }

    public void deletePost(Integer id){
        Post p=postRepository.findPostById(id);
        if(p==null){
            throw new ApiExeption("wrong id");

        }
        postRepository.delete(p);

    }


    public List<Post> searchByuserid(Integer userId){
        List<Post> p=postRepository.findPostByUserid(userId);
        if(p.isEmpty()){
            throw new ApiExeption("not found");
        }
        return p;
    }

    public List<Post> searchBytitle(String title){
        List<Post> p=postRepository.findPostByTitle(title);
        if(p.isEmpty()){
            throw new ApiExeption("not found");
        }
        return p;
    }

    public List<Post> searchBydate(LocalDate publishDate){
        List<Post> p=postRepository.findPostByPublishDateBefore(publishDate);
        if(p.isEmpty()){
            throw new ApiExeption("not found");
        }
        return p;
    }

}
