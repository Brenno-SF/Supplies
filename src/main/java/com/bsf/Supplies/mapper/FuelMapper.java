package com.bsf.Supplies.mapper;

import com.bsf.Supplies.dto.FuelDTO;
import com.bsf.Supplies.entity.Fuel;
import org.springframework.stereotype.Component;


@Component
public class FuelMapper {
    public static FuelDTO toDTO(Fuel fuel){
        return new FuelDTO(
                fuel.getId(),
                fuel.getName(),
                fuel.getPrice()
        );
    }
    public static Fuel toDomain(FuelDTO fuelDTO){
        return new Fuel(
                fuelDTO.id(),
                fuelDTO.name(),
                fuelDTO.price()
        );
    }
}
