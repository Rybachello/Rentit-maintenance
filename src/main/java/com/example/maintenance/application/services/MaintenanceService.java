package com.example.maintenance.application.services;

import com.example.maintenance.application.dto.MaintenanceTaskDTO;
import com.example.maintenance.domain.model.MaintenanceTask;
import com.example.maintenance.domain.repository.MaintenanceTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Rybachello on 3/7/2017.
 */
@Service
public class MaintenanceService {
    @Autowired
    MaintenanceTaskRepository repository;

    @Autowired
    MaintenanceTaskDisassembler maintenanceTaskDisassembler;

    public void createMaintenanceTask(MaintenanceTaskDTO taskDTO) {
        MaintenanceTask task = maintenanceTaskDisassembler.toResources(taskDTO);
        repository.save(task);
    }
}
