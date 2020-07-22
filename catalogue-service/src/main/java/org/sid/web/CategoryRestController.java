package org.sid.web;

import org.sid.dao.CategoryRepsitory;
import org.sid.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/category")
public class CategoryRestController {

    @Autowired
    private CategoryRepsitory categoryRepsitory;



    @GetMapping("/all")
    public List<Category> listAll(){
        return categoryRepsitory.findAll();
    }


    @GetMapping("/getone/{id}")
    public Category getCategorieById(@PathVariable Long id) {
        return categoryRepsitory.getOne(id);


    }

    @PostMapping("/save")
    private  Category saveEtudiant(@RequestBody Category category){

        return categoryRepsitory.save(category);
    }

    @PutMapping("/update/{id}")
    public Category UpdateCategory (@RequestBody Category category ,@PathVariable Long id) {

        category.setId(id);
        return categoryRepsitory.saveAndFlush(category);

    }
}
