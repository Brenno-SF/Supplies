package com.bsf.Supplies.mapper;

import com.bsf.Supplies.dto.FuelDTO;
import com.bsf.Supplies.dto.PumpDTO;
import com.bsf.Supplies.entity.Fuel;
import com.bsf.Supplies.entity.Pump;
import org.springframework.stereotype.Component;

@Component
public class PumpMapper {

    public static Pump toDomain(PumpDTO pumpDTO){
        return new Pump(
                pumpDTO.id(),
                pumpDTO.name(),
                FuelMapper.toDomain(pumpDTO.fuel())
        );
    }

    public static PumpDTO toDto(Pump pump){
        return new PumpDTO(
                pump.getId(),
                pump.getName(),
                FuelMapper.toDTO(pump.getFuel())
        );
    }



}
