package com.bsf.Supplies.service;

import com.bsf.Supplies.dto.FuelDTO;
import com.bsf.Supplies.entity.Fuel;
import com.bsf.Supplies.mapper.FuelMapper;
import com.bsf.Supplies.repository.FuelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelService {
    private final FuelRepository fuelRepository;
    private final FuelMapper fuelMapper;

    public FuelService(FuelRepository fuelRepository, FuelMapper fuelMapper) {
        this.fuelRepository = fuelRepository;
        this.fuelMapper = fuelMapper;
    }

    public FuelDTO createFuel(FuelDTO fuelDTO) {

        Fuel fuel = fuelMapper.toDomain(fuelDTO);
        Fuel fuelSaved = fuelRepository.save(fuel);

        return fuelMapper.toDTO(fuelSaved);
    }
    public List<FuelDTO> getAllFuels(){
        List<Fuel> fuels = fuelRepository.findAll();
        return fuels.stream()
                .map(fuelMapper::toDTO)
                .toList();
    }

}
