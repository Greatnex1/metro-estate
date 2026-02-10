package com.nouah.metroestate.dto;

import com.nouah.metroestate.model.entity.Permission;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class PermissionDto {
    private Long id;

    private String name;

    private String description;

    private String category;
    public PermissionDto(){}

    public PermissionDto(Permission permission){
        this.name = permission.getName();
        this.description = permission.getDescription();
    }
}
