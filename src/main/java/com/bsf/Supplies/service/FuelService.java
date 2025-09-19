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

    public FuelService(FuelRepository fuelRepository) {
        this.fuelRepository = fuelRepository;
    }


    public FuelDTO create(FuelDTO fuelDTO) {

        Fuel fuel = FuelMapper.toDomain(fuelDTO);
        Fuel fuelSaved = fuelRepository.save(fuel);

        return FuelMapper.toDTO(fuelSaved);
    }
    public List<FuelDTO> getAll(){
        List<Fuel> fuels = fuelRepository.findAll();
        return fuels.stream()
                .map(FuelMapper::toDTO)
                .toList();
    }
    public FuelDTO getById(Long id){
        Fuel fuel = fuelRepository.findById(id).orElseThrow(() ->
                new ResourseNotFoundException("Fuel not found"));

        return FuelMapper.toDTO(fuel);

    }
    public FuelDTO update(Long id, FuelDTO fuelDTO){
        Fuel fuel = fuelRepository.findById(id).orElseThrow(() ->
                new ResourseNotFoundException("Fuel not found"));

        fuel.setName(fuelDTO.name());
        fuel.setPrice(fuelDTO.price());

        Fuel fuelUpdated = fuelRepository.save(fuel);


        return FuelMapper.toDTO(fuelUpdated);

    }
    public void delete(Long id){
        Fuel fuel = fuelRepository.findById(id).orElseThrow(() ->
                new ResourseNotFoundException("Fuel not found"));
        fuelRepository.deleteById(id);
    }

}
