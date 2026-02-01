package com.nouah.metroestate.security.service;

import com.nouah.metroestate.dto.EstateDto;
import com.nouah.metroestate.dto.response.PaginatedResponse;
import com.nouah.metroestate.model.entity.Estate;
import jakarta.transaction.Transactional;

import java.util.List;

public interface EstateService {
    @Transactional
    EstateDto onboardEstate(EstateDto estateRequest);

    PaginatedResponse<List<EstateDto>> fetchAllEstatesBy(int page, int size, String country, String state, String city, String estateId);

    Estate getEstateById(String estateId);
}
