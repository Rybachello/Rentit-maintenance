package com.example.maintenance.rest.controller;

import com.example.maintenance.application.dto.MaintenanceTaskDTO;
import com.example.maintenance.application.services.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Rybachello on 3/11/2017.
 */
@RestController
@RequestMapping("/api/maintenances")
public class MaintenanceRestController {
    @Autowired
    MaintenanceService maintenanceService;

    @PostMapping("/tasks")
    public ResponseEntity<Boolean> createMaintenanceTask(@RequestBody MaintenanceTaskDTO taskDTO) {
        maintenanceService.createMaintenanceTask(taskDTO);
        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<>(Boolean.TRUE, headers, HttpStatus.CREATED);
    }

    @PostMapping("/tasks/check")
    public Boolean checkForMaintenance(@RequestBody MaintenanceTaskDTO taskDTO) {
        Boolean b = maintenanceService.checkForMaintenance(taskDTO);
        return b;
    }

//    @GetMapping("/plants/{id}")
//    public PlantInventoryEntryDTO findPlantEntry(@PathVariable String id) {
//        return maintenanceService.getEntryById(id);
//    }
}
