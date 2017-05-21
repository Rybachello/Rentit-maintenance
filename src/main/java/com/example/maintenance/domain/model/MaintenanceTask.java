package com.example.maintenance.domain.model;

import com.example.common.domain.model.BusinessPeriod;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

/**
 * Created by Vasiliy on 2017.02.20.
 */

@Entity
@Getter
@NoArgsConstructor(force=true, access= AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "of")
public class MaintenanceTask {
    @Id
    String id;

    String description;

    BusinessPeriod period;

    @Enumerated(EnumType.STRING)
    TypeOfWork typeOfWork;

    String plantId;
    //PlantInventoryItemDTO plantItem;
}
