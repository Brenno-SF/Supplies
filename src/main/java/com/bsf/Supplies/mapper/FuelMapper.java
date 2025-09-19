package com.bsf.Supplies.mapper;

import com.bsf.Supplies.dto.FuelDTO;
import com.bsf.Supplies.entity.Fuel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FuelMapper {
    public FuelDTO toDTO(Fuel fuel){
        return new FuelDTO(
                fuel.getId(),
                fuel.getName(),
                fuel.getPrice()
        );
    }
    public Fuel toDomain(FuelDTO fuelDTO){
        return new Fuel(
                fuelDTO.id(),
                fuelDTO.name(),
                fuelDTO.price()
        );
    }
}
