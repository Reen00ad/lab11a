package com.example.lab11a.Controller;

import com.example.lab11a.ApiResponce.ApiResponce;
import com.example.lab11a.Model.Category;
import com.example.lab11a.Model.Comment;
import com.example.lab11a.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/get")
    public ResponseEntity getAllCategory(){
        return ResponseEntity.status(200).body(categoryService.getAllCategory());
    }


    @PostMapping("/add")
    public ResponseEntity addCategory(@RequestBody @Valid Category category, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        categoryService.addCategory(category);
        return ResponseEntity.status(200).body(new ApiResponce("category added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCategory(@PathVariable Integer id,@RequestBody @Valid Category category,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        categoryService.updateCategory(id, category);
        return ResponseEntity.status(200).body(new ApiResponce("category updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable Integer id){
        categoryService.deleteCategory(id);

        return ResponseEntity.status(200).body(new ApiResponce("category deleted"));
    }

    @GetMapping("/names/{ch}")
    public ResponseEntity namestart(@PathVariable String ch){
        return ResponseEntity.status(200).body(categoryService.namestart(ch));
    }

}
