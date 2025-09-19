package com.bsf.Supplies.mapper;

import com.bsf.Supplies.dto.SupplyDTO;
import com.bsf.Supplies.entity.Supply;
import org.springframework.stereotype.Component;

@Component
public class SupplyMapper {
    public static Supply toDomain(SupplyDTO supplyDTO){

        return new Supply(
                supplyDTO.id(),
                supplyDTO.name(),
                supplyDTO.liters(),
                supplyDTO.totalPrice(),
                supplyDTO.date(),
                PumpMapper.toDomain(supplyDTO.pump())
        );
    }
    public static SupplyDTO toDTO(Supply supply){
        return new SupplyDTO(
                supply.getId(),
                supply.getName(),
                supply.getDate(),
                PumpMapper.toDTO(supply.getPump()),
                supply.getLiters(),
                supply.getTotalPrice()
        );
    }

}
