package com.example.common.application.services;


import com.example.common.application.dto.BusinessPeriodDTO;
import com.example.common.domain.model.BusinessPeriod;
import org.springframework.stereotype.Service;

/**
 * Created by Rybachello on 3/11/2017.
 */
@Service
public class BusinessPeriodAssembler {
    public BusinessPeriodDTO toResources(BusinessPeriod businessPeriod)
    {
        return BusinessPeriodDTO.of(businessPeriod.getStartDate(),businessPeriod.getEndDate());
    }
}
