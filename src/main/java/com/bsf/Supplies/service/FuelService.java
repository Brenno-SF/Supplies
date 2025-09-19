package com.bsf.Supplies.service;

import com.bsf.Supplies.dto.FuelDTO;
import com.bsf.Supplies.entity.Fuel;
import com.bsf.Supplies.exception.ResourseNotFoundException;
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

    public FuelDTO create(FuelDTO fuelDTO) {

        Fuel fuel = fuelMapper.toDomain(fuelDTO);
        Fuel fuelSaved = fuelRepository.save(fuel);

        return fuelMapper.toDTO(fuelSaved);
    }
    public List<FuelDTO> getAll(){
        List<Fuel> fuels = fuelRepository.findAll();
        return fuels.stream()
                .map(fuelMapper::toDTO)
                .toList();
    }
    public FuelDTO getById(Long id){
        Fuel fuel = fuelRepository.findById(id).orElseThrow(() ->
                new ResourseNotFoundException("Fuel not found"));

        return fuelMapper.toDTO(fuel);

    }
    public FuelDTO update(Long id, FuelDTO fuelDTO){
        Fuel fuel = fuelRepository.findById(id).orElseThrow(() ->
                new ResourseNotFoundException("Fuel not found"));

        fuel.setName(fuelDTO.name());
        fuel.setPrice(fuelDTO.price());

        Fuel fuelUpdated = fuelRepository.save(fuel);


        return fuelMapper.toDTO(fuelUpdated);

    }

}
