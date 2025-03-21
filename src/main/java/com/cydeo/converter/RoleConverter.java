package com.cydeo.converter;

import com.cydeo.dto.RoleDTO;
import com.cydeo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class RoleConverter implements Converter<String, RoleDTO> {

    RoleService roleService;

    @Autowired
    public void setter(RoleService roleService){
        this.roleService=roleService;
    }
    

    @Override
    public RoleDTO convert(String source) {
        return roleService.findById(Long.parseLong(source));
    }
}
