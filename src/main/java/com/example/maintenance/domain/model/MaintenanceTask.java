package com.example.maintenance.domain.model;

import com.example.common.domain.model.BusinessPeriod;
import com.example.maintenance.application.dto.PlantInventoryItemDTO;
import lombok.*;

import javax.persistence.*;

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

    PlantInventoryItemDTO plantItem;
}
