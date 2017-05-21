package com.example.maintenance.domain.model;

import com.example.common.application.dto.BusinessPeriodDTO;
import com.example.maintenance.application.dto.PlantInventoryItemDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * Created by Vasiliy on 2017-05-21.
 */
@Data
@EqualsAndHashCode
public class MaintenanceNotificationDTO {
    BusinessPeriodDTO period;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="_id", column=@Column(name="plant_id")),
            @AttributeOverride(name="href", column=@Column(name="plant_href"))
    })
    PlantInventoryItemDTO plantItem;
}
