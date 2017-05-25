package com.example.maintenance.application.services;

import com.example.common.application.services.BusinessPeriodAssembler;
import com.example.maintenance.application.dto.MaintenanceTaskDTO;
import com.example.maintenance.application.dto.MaintenanceNotificationDTO;
import com.example.maintenance.domain.model.MaintenanceTask;
import com.example.maintenance.domain.repository.MaintenanceTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Rybachello on 3/7/2017.
 */
@Service
public class MaintenanceService {
    @Autowired
    MaintenanceTaskRepository repository;

    @Autowired
    MaintenanceTaskDisassembler maintenanceTaskDisassembler;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    BusinessPeriodAssembler businessPeriodAssembler;

    public void createMaintenanceTask(MaintenanceTaskDTO taskDTO) {
        MaintenanceTask task = maintenanceTaskDisassembler.toResources(taskDTO);
        repository.save(task);

        // run 'notify' in parallel
        new Thread(new Runnable() {
            public void run() {
                notifyRentit(task);
            }
        }).start();
    }

    private void notifyRentit(MaintenanceTask task) {
        MaintenanceNotificationDTO note = new MaintenanceNotificationDTO();
        note.setMaintenancePeriod(businessPeriodAssembler.toResources(task.getPeriod()));
        note.set_id(task.getPlantId());
        restTemplate.postForObject(
                "http://localhost:8090/api/inventory/maintenance/plants",
                note,
                String.class);
    }

    public Boolean checkForMaintenance(MaintenanceTaskDTO task) {
        List<MaintenanceTask> tasks = repository.findPlantTasksInPeriod(
                task.getPlantId(),
                task.getMaintenancePeriod().getStartDate(),
                task.getMaintenancePeriod().getEndDate());
        return tasks.size()>0;
    }
}
