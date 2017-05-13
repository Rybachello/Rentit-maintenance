package com.example.maintenance.rest.controller;

import com.example.maintenance.application.dto.MaintenanceTaskDTO;
import com.example.maintenance.application.services.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Rybachello on 3/11/2017.
 */
@RestController
@RequestMapping("/api/maintenance")
public class MaintenanceRestController {
    @Autowired
    MaintenanceService maintenanceService;

    @PostMapping("/tasks")
    public ResponseEntity<Boolean> createPurchaseOrder(@RequestBody MaintenanceTaskDTO taskDTO) {
        maintenanceService.createMaintenanceTask(taskDTO);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(Boolean.TRUE, headers, HttpStatus.CREATED);
    }


//    @GetMapping("/plants")
//    public List<PlantInventoryEntryDTO> findAvailablePlants() {
//        return maintenanceService.allPlants();
//    }
//
//    @GetMapping("/plants/{id}")
//    public PlantInventoryEntryDTO findPlantEntry(@PathVariable String id) {
//        return maintenanceService.getEntryById(id);
//    }
}
