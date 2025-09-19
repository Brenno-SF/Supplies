package com.bsf.Supplies.mapper;

import com.bsf.Supplies.dto.PumpDTO;
import com.bsf.Supplies.entity.Pump;
import org.springframework.stereotype.Component;

@Component
public class PumpMapper {
    public static Pump toDomain(PumpDTO pumpDTO){
        if (pumpDTO == null) return null;
        return new Pump(
                pumpDTO.id(),
                pumpDTO.name(),
                pumpDTO.fuel() != null ? FuelMapper.toDomain(pumpDTO.fuel()) : null
        );
    }

    public static PumpDTO toDTO(Pump pump){
        return new PumpDTO(
                pump.getId(),
                pump.getName(),
                FuelMapper.toDTO(pump.getFuel())
        );
    }



}
