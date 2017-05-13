package com.example.maintenance.application.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.example.common.rest.ResourceSupport;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

/**
 * Created by Rybachello on 3/7/2017.
 */

@Data
@EqualsAndHashCode
@Embeddable
public class PlantInventoryItemDTO extends ResourceSupport {
    private String _id;
    private String href;
}
