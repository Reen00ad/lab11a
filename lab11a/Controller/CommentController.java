package com.example.lab11a.Controller;

import com.example.lab11a.ApiResponce.ApiResponce;
import com.example.lab11a.Model.Comment;
import com.example.lab11a.Model.Post;
import com.example.lab11a.Service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/get")
    public ResponseEntity getAllComment(){
        return ResponseEntity.status(200).body(commentService.getAllComment());
    }


    @PostMapping("/add")
    public ResponseEntity addComment(@RequestBody @Valid Comment comment, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        commentService.addComment(comment);
        return ResponseEntity.status(200).body(new ApiResponce("comment added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateComment(@PathVariable Integer id,@RequestBody @Valid Comment comment,Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        commentService.updateComment(id, comment);

        return ResponseEntity.status(200).body(new ApiResponce("comment updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteComment(@PathVariable Integer id){
        commentService.deleteComment(id);

        return ResponseEntity.status(200).body(new ApiResponce("comment deleted"));

    }

    @GetMapping("/commentBypostid/{postid}")
    public ResponseEntity commentBypostid(@PathVariable Integer postid){
        return ResponseEntity.status(200).body(commentService.commentBypostid(postid));

    }

    @GetMapping("/commentBypostiduserid/{postid}/{userid}")
    public ResponseEntity commentBypostiduserid(@PathVariable Integer postid,@PathVariable Integer userid){
        return ResponseEntity.status(200).body(commentService.commentBypostiduserid(postid, userid));

    }

    @GetMapping("/commdate/{date1}")
    public ResponseEntity commentdate(@PathVariable LocalDate date1){
        return ResponseEntity.status(200).body(commentService.commentdate(date1));
    }


}
