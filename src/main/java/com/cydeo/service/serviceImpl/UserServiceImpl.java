package com.cydeo.service.serviceImpl;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends AbstractMapMockDB<String,UserDTO> implements UserService {

    @Override
    public UserDTO save(UserDTO object) {
         // Primary key needs to be added if necessary
        if(!object.isEnabled())
            object.setEnabled(true);

        return super.save(object.getUserName(),object);
    }

    @Override
    public UserDTO findById(String userName) {
        return super.findById(userName);
    }

    @Override
    public List<UserDTO> findAll() {
          return super.findAll();
    }

    @Override
    public void update(String userName, UserDTO object) {
        super.update(userName,object);
    }

    @Override
    public void deleteById(String userName) {
       super.deleteById(userName);
    }

    @Override
    public void softDeleteById(String userName) {
        super.softDeleteById(userName);
    }

    @Override
    public List<UserDTO> searchUser(String pattern) {
        return this.findAll().stream()
                .filter(userDTO->userDTO.getUserName().toLowerCase().contains(pattern.toLowerCase())
                || (userDTO.getFirstName()+" "+userDTO.getLastName()).toLowerCase().contains(pattern.toLowerCase())
                        || userDTO.getPhone().contains(pattern.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findManagers() {
        return this.findAll().stream()
                .filter(eachUserDTO->eachUserDTO.getRole().getDescription().equalsIgnoreCase("Manager"))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, UserDTO> createAll(List<UserDTO> list) {
        return this.dbMap=list.stream()
                .collect(Collectors.toMap(UserDTO::getUserName, UserDTO->UserDTO));
    }
}
