package com.cydeo.service;

import com.cydeo.dto.UserDTO;

import java.util.List;

public interface UserService extends CurdService<String, UserDTO>{
    @Override
    UserDTO save(UserDTO object);

    @Override
    UserDTO findById(String s);

    @Override
    List<UserDTO> findAll();

    @Override
    void deleteById(String s);

    void softDeleteById(String s);

    List<UserDTO> searchUser(String pattern);

    List<UserDTO> findManagers();
}
