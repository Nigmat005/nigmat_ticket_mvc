package com.cydeo.service.serviceImpl;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
   protected Map<String,UserDTO> map=new HashMap<>();
    @Override
    public UserDTO save(UserDTO object) {
        map.put(object.getUserName(),object);
        return object;
    }

    @Override
    public UserDTO findById(String userName) {
        return map.get(userName);
    }

    @Override
    public List<UserDTO> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void deleteById(String userName) {
        map.remove(userName);
    }
}
