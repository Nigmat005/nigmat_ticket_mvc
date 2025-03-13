package com.cydeo.controller;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }





    // pass object to Model using @@ModelAttribute as parameter in method

//    @RequestMapping(value="/create", method = RequestMethod.GET)
//    public String createUser(@ModelAttribute("userDTO") UserDTO userDTO){
//
//        return "user/create";
//    }

    // pass object to Model using @Model interface and use addAttribute method to pass object to model
//    @RequestMapping(value="/create", method = RequestMethod.GET)
//    public String createUser(Model model){
//     model.addAttribute("userDTO",new UserDTO());
//        return "user/create";
//    }

    @ModelAttribute("userDTO")
    public UserDTO getUser(){
        return new UserDTO();
    }
    @RequestMapping(value="/create", method = RequestMethod.GET)
        public String createUser(Model model){
        model.addAttribute("roleList",roleService.findAll());
        return "user/create";
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String saveUser(){
        return "redirect:/user/create";
    }
}
