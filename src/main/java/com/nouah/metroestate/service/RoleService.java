package com.nouah.metroestate.service;

import com.nouah.metroestate.dto.RoleDto;
import com.nouah.metroestate.dto.request.RoleDtoRequest;
import com.nouah.metroestate.dto.request.RoleUpdateRequest;
import com.nouah.metroestate.dto.response.ApiResponse;
import com.nouah.metroestate.dto.response.PaginatedResponse;
import com.nouah.metroestate.model.entity.Role;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Role createUserRole(RoleDto roleDto);
    Optional<Role> findRoleByName(String name);

    PaginatedResponse<List<RoleDto>> findAll(Pageable pageable);

    ApiResponse assignRole(String roleName, String phoneNumber);

    RoleDto createRole(RoleDtoRequest roleRequest);

    RoleDto updateRoleAddPermission(String roleName, RoleUpdateRequest roleRequest);

    ApiResponse deleteRole(String name);
}
