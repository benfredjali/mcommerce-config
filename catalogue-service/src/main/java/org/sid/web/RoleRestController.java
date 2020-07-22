package org.sid.web;

import org.sid.dao.AppRoleRepository;
import org.sid.entities.AppRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleRestController {

    @Autowired
    private AppRoleRepository appRoleRepository;


    @GetMapping("/all")
    public List<AppRole> listAll(){
        return appRoleRepository.findAll();
    }
//    @PostMapping("/save")
//    private  AppRole saveRole(@RequestBody AppRole role){
//
//        return appRoleRepository.save(role);
//    }


}
