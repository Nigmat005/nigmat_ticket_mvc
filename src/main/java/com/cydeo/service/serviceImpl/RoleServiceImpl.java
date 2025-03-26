package com.cydeo.service.serviceImpl;


import com.cydeo.dto.RoleDTO;
import com.cydeo.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl extends AbstractMapMockDB<Long,RoleDTO> implements RoleService {


    @Override
    public RoleDTO save(RoleDTO object) {
        return super.save(object.getId(),object);
    }

    @Override
    public List<RoleDTO> findAll() {
        return super.findAll();
    }


    @Override
    public RoleDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }


    @Override
    public Map<Long,RoleDTO> createAll(List<RoleDTO> list) {
      return   dbMap=list.stream()
                .collect(Collectors.toMap(RoleDTO::getId, eachRole->eachRole));
    }

    public boolean checkRoleMap(){
        Predicate<Map<Long,RoleDTO>> checkMap=(map)->{return !map.isEmpty();};
        return checkMap.test(super.dbMap);
    }
}
