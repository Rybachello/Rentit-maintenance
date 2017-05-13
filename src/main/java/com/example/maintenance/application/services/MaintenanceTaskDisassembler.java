package com.example.maintenance.application.services;


import com.example.common.application.dto.BusinessPeriodDTO;
import com.example.common.application.services.BusinessPeriodDisassembler;
import com.example.common.domain.model.BusinessPeriod;
import com.example.maintenance.application.dto.MaintenanceTaskDTO;
import com.example.maintenance.domain.model.MaintenanceTask;
import com.example.maintenance.infrastructure.IdentifierFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Rybachello on 3/11/2017.
 */
@Service
public class MaintenanceTaskDisassembler {
    @Autowired
    BusinessPeriodDisassembler businessPeriodDisassembler;

    public MaintenanceTask toResources(MaintenanceTaskDTO dto)
    {
        return MaintenanceTask.of(
                IdentifierFactory.nextID(),
                dto.getDescription(),
                businessPeriodDisassembler.toResources(dto.getPeriod()),
                dto.getTypeOfWork(),
                dto.getPlantItem());
    }
}
