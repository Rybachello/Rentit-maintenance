package com.example.maintenance.application.dto;

import com.example.common.application.dto.BusinessPeriodDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Vasiliy on 2017-05-21.
 */
@Data
@EqualsAndHashCode
public class MaintenanceNotificationDTO {
    BusinessPeriodDTO maintenancePeriod;

    String _id;
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name="_id", column=@Column(name="plant_id")),
//            @AttributeOverride(name="href", column=@Column(name="plant_href"))
//    })
//    PlantInventoryItemDTO plantItem;
}
