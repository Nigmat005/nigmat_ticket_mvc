package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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





    // pass object to Model using @ModelAttribute as parameter in method

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
        public String createUser(@RequestParam(value = "keyword",required = false) String keyword, Model model){
        model.addAttribute("roleList",roleService.findAll());
        model.addAttribute("userList",userService.findAll());

        if(keyword!=null && !keyword.isEmpty()){
           model.addAttribute("filtered_UserList",userService.searchUser(keyword));
           model.addAttribute("pattern",keyword); // display the name you have searched
        }
        else{
            model.addAttribute("pattern", "");
        }
        return "user/create";
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("userDTO") UserDTO userDTO){
        userService.save(userDTO);
        return "redirect:/user/create";
    }

    @GetMapping(value = "/update")
    public String updateUser(@RequestParam(value = "primaryKey") String userName,Model model){

        // based on primaryKey get the user object and populate it here
        // and if you use @RequestParam(value = "primaryKey_userName") then it means you have to use primaryKey_userName as its variable not userName
        model.addAttribute("userTobeUpdated",userService.findById(userName));
        model.addAttribute("roleList",roleService.findAll());
        model.addAttribute("userList",userService.findAll());
        return "/user/update";
    }

    @PostMapping(value = "/update")
    public String saveUpdateUser( @ModelAttribute("userTobeUpdated") UserDTO updatedUser){
        userService.update(updatedUser.getUserName(), updatedUser);
        System.out.println("UniqueKey: -> "+updatedUser.getUserName());
        return "redirect:/user/create";
    }

    @GetMapping(value = "/delete/{primaryKey}")
    public String deleteUser(@PathVariable("primaryKey") String userName){
        userService.softDeleteById(userName);
        return "redirect:/user/create";
    }


//    @GetMapping(value = "/search")
//    public String searchUser(@RequestParam("keyword") String keyword, Model model){
//           System.out.println("keyword = " + keyword);
//           model.addAttribute("filtered_UserList",userService.searchUser(keyword));
//           model.addAttribute("pattern",keyword);
//        return "forward:/user/create";
//
//    }


}
