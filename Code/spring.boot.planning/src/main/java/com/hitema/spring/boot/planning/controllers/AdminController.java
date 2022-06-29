package com.hitema.spring.boot.planning.controllers;

import com.hitema.spring.boot.planning.entities.User;
import com.hitema.spring.boot.planning.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    private UserService service;

    public  AdminController(UserService service){
        this.service = service;
    }

    @GetMapping("/add")
    public String AddUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "add_user";
    }

    @GetMapping("/remove")
    public String RemoveUser(ModelMap model) {
        log.info("readAll user called ...");
        model.addAttribute("users", service.readAll());
        return "remove_user";
    }
    @PostMapping("/add")
    public String retrieveUser(@ModelAttribute("user") User user){
        log.info(user.toString());
        service.create(user);
        return "index_admin";

    }
    /*@GetMapping("/prom")
    public String PromUser(ModelMap model) { return "remove_user";}*/

}
