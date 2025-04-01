package com.cydeo.converter;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements Converter<String, UserDTO> {
   private final UserService userService;

   @Autowired
   public UserConverter(UserService userService){
       this.userService=userService;
   }
    @Override
    public UserDTO convert(String userName) {
        return userService.findById(userName);
    }
}
