package com.example.lab11a.Service;

import com.example.lab11a.ApiResponce.ApiExeption;
import com.example.lab11a.Model.Category;
import com.example.lab11a.Model.Comment;
import com.example.lab11a.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    public void addCategory(Category category){
        categoryRepository.save(category);
    }

    public void updateCategory(Integer id,Category category){

        Category c=categoryRepository.findCategoryById(id);

        if(c==null){
            throw new ApiExeption("wrong id");

        }

        c.setName(category.getName());

        categoryRepository.save(c);

}
       public void deleteCategory(Integer id){
        Category c=categoryRepository.findCategoryById(id);
        if(c==null){
            throw new ApiExeption("wrong id");

        }
        categoryRepository.delete(c);

    }

    public List<Category> namestart(String ch){
        List<Category> c=categoryRepository.names(ch);
        if(c.isEmpty()){
            throw new ApiExeption("not found");
        }
        return c;
    }


}
