package com.bsf.Supplies.service;

import com.bsf.Supplies.dto.FuelDTO;
import com.bsf.Supplies.dto.PumpDTO;
import com.bsf.Supplies.entity.Fuel;
import com.bsf.Supplies.entity.Pump;
import com.bsf.Supplies.exception.ResourseNotFoundException;
import com.bsf.Supplies.mapper.FuelMapper;
import com.bsf.Supplies.mapper.PumpMapper;
import com.bsf.Supplies.repository.FuelRepository;
import com.bsf.Supplies.repository.PumpRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PumpService {
    private final PumpRepository pumpRepository;
    private final FuelRepository fuelRepository;

    public PumpService(PumpRepository pumpRepository, FuelRepository fuelRepository) {
        this.pumpRepository = pumpRepository;
        this.fuelRepository = fuelRepository;
    }

    @Transactional
    public PumpDTO create(PumpDTO pumpDTO){

        Fuel fuel = fuelRepository.findById(pumpDTO.fuel().id()).orElseThrow(()->
                new ResourseNotFoundException("Fuel not found"));

        Pump pump = PumpMapper.toDomain(pumpDTO);

        pump.setFuel(fuel);

        Pump pumpSaved = pumpRepository.save(pump);

        return PumpMapper.toDto(pumpSaved);
    }

    public List<PumpDTO> getAll(){
        List<Pump> pumps = pumpRepository.findAll();
        return pumps.stream()
                .map(PumpMapper::toDto)
                .toList();
    }

    public PumpDTO getById(Long id){
        Pump pump = pumpRepository.findById(id).orElseThrow(()->
                new ResourseNotFoundException("pump not found"));

        return PumpMapper.toDto(pump);
    }
    public PumpDTO updateById(Long id, PumpDTO pumpDTO){
        Pump pump = pumpRepository.findById(id).orElseThrow(()->
                new ResourseNotFoundException("pump not found"));

        pump.setName(pump.getName());

        Pump pumpUpdated = pumpRepository.save(pump);
        return PumpMapper.toDto(pumpUpdated);
    }
}
