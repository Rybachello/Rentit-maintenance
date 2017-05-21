package com.example.maintenance.domain.repository;

import com.example.maintenance.domain.model.MaintenanceTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by stepan on 17/02/2017.
 */
@Repository
public interface MaintenanceTaskRepository extends JpaRepository<MaintenanceTask, String> {
    @Query("SELECT t FROM MaintenanceTask WHERE t.plantItem._id = ?1 AND t.period.startDate < ?3 AND t.period.endDate > ?2")
    List<MaintenanceTask> findPlantTasksInPeriod(String plantId, LocalDate startDate, LocalDate endDate);

}
