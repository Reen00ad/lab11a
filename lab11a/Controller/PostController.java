package com.example.lab11a.Controller;

import com.example.lab11a.ApiResponce.ApiResponce;
import com.example.lab11a.Model.Post;
import com.example.lab11a.Model.User;
import com.example.lab11a.Service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/get")
    public ResponseEntity getAllPost(){
        return ResponseEntity.status(200).body(postService.getAllPost());
    }


    @PostMapping("/add")
    public ResponseEntity addPost(@RequestBody @Valid Post post, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }postService.addPost(post);
        return ResponseEntity.status(200).body(new ApiResponce("post added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updatePost(@PathVariable Integer id,@RequestBody @Valid Post post,Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        postService.updatePost(id, post);

        return ResponseEntity.status(200).body(new ApiResponce("post updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePost(@PathVariable Integer id){
        postService.deletePost(id);

        return ResponseEntity.status(200).body(new ApiResponce("post deleted"));

    }

    @GetMapping("/searchuserid/{userid}")
    public ResponseEntity searchbyuserid(@PathVariable Integer userid){
        return ResponseEntity.status(200).body(postService.searchByuserid(userid));
    }

    @GetMapping("/searchtitle/{title}")
    public ResponseEntity searchbytitle(@PathVariable String title){
        return ResponseEntity.status(200).body(postService.searchBytitle(title));
    }

    @GetMapping("/searchdate/{publishDate}")
    public ResponseEntity searchbydate(@PathVariable LocalDate publishDate){
        return ResponseEntity.status(200).body(postService.searchBydate(publishDate));
    }


}
