package com.nogayhusrev.converter;

import com.nogayhusrev.dto.RoleDTO;
import com.nogayhusrev.service.RoleService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class RoleDtoConverter implements Converter<String, RoleDTO> {


    RoleService roleService;

    public RoleDtoConverter(@Lazy RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public RoleDTO convert(String source) {

        if (source == null || source.equals("")) {
            return null;
        }

        return roleService.findById(Long.parseLong(source));

    }

}
