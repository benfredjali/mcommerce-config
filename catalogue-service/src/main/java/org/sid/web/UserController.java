package org.sid.web;

import org.sid.dao.AppUserRepository;
import org.sid.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

@Autowired
private AppUserRepository appUserRepository;

    @GetMapping("/all")
    public List<AppUser> listAll(){
        return appUserRepository.findAll();
    }



    }



