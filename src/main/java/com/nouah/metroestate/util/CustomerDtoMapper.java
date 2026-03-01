package com.nouah.metroestate.util;

import com.nouah.metroestate.dto.CustomerDto;
import com.nouah.metroestate.dto.RoleDto;
import com.nouah.metroestate.model.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoMapper {

    public CustomerDto toCustomerDto(UserEntity user) {
        CustomerDto dto = new CustomerDto();

        dto.setEmailAddress(user.getEmail());
        dto.setPassword(user.getPassword());

        if (user.getRole() != null) {
            RoleDto roleDto = new RoleDto();
           roleDto.setId(user.getRole().getId());
            roleDto.setName(user.getRole().getName());
            dto.setRole(roleDto);
        }

        return dto;
    }
}
