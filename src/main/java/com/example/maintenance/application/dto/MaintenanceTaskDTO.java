package com.example.maintenance.application.dto;

import com.example.common.application.dto.BusinessPeriodDTO;
import com.example.maintenance.domain.model.TypeOfWork;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * Created by Vasiliy on 2017-05-13.
 */
@Data
@EqualsAndHashCode
public class MaintenanceTaskDTO {
    String description;

    BusinessPeriodDTO period;

    @Enumerated(EnumType.STRING)
    TypeOfWork typeOfWork;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="_id", column=@Column(name="plant_id")),
            @AttributeOverride(name="href", column=@Column(name="plant_href"))
    })
    PlantInventoryItemDTO plantItem;
}

