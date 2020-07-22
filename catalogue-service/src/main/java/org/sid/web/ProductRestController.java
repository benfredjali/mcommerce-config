package org.sid.web;

import org.sid.dao.AppUserRepository;
import org.sid.dao.CategoryRepsitory;
import org.sid.dao.ProductRepository;
import org.sid.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;



@RestController
@RequestMapping(value="/product", method=RequestMethod.GET)
@CrossOrigin("*")
public class ProductRestController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepsitory categoryRepsitory;
    @Autowired
    private AppUserRepository appUserRepository;



    @GetMapping("/all")

    public List<Product> listAll(){

        return  productRepository.findAll();
    }


//    @PostMapping("/save/{idCateg}/{idU}")
//    private  Product save(@RequestBody Product product, @PathVariable Long idCateg,@PathVariable Long idU){
//
//
////        product.setAppUser(appUserRepository.getOne(idUser));
////        System.out.println("idUser"+idUser);
//
//
//        product.setCategory(categoryRepsitory.getOne(idCateg));
//        product.setAppUser(appUserRepository.getOne(idU));
//        System.out.println("idU"+idU);
//
//        return productRepository.saveAndFlush(product);
//
//    }


//    @GetMapping("/getone/{id}")
//    public Product findById(@PathVariable Long id) {
//        return productRepository.getOne(id);
//
//    }

    @PutMapping("/update/{id}/{idCateg}/{idU}")
    public Product updateProduct (@RequestBody Product product, @PathVariable Long id,@PathVariable Long idU,@PathVariable Long idCateg){

       product.setId(id);
       product.setCategory(categoryRepsitory.getOne(idCateg));
       product.setAppUser(appUserRepository.getOne(idU));

       return productRepository.saveAndFlush(product);
    }

    @DeleteMapping("/delete/{id}")
    public HashMap deletecommentaire(@PathVariable Long id) {
        HashMap<String,String> hashMap= new HashMap<>();
        try {
            productRepository.deleteById(id);
            hashMap.put("state","yes");
            return  hashMap;
        } catch (Exception e) {
            hashMap.put("state","no");
            return hashMap;
        }
    }



}
