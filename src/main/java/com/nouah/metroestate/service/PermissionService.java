package com.nouah.metroestate.service;

import com.nouah.metroestate.dto.PermissionDto;
import com.nouah.metroestate.dto.response.ApiResponse;
import com.nouah.metroestate.dto.response.PaginatedResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PermissionService {
    PaginatedResponse<List<PermissionDto>> findAll(Pageable pageable);

//    PaginatedResponse<List<PermissionByCategoryDto>> findAllByCategory(Pageable pageable);

    ApiResponse assignPermission(String phone, String permission);
}

