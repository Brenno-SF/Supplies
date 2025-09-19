package com.bsf.Supplies.service;

import com.bsf.Supplies.dto.SupplyDTO;
import com.bsf.Supplies.entity.Pump;
import com.bsf.Supplies.entity.Supply;
import com.bsf.Supplies.exception.ResourseNotFoundException;
import com.bsf.Supplies.mapper.SupplyMapper;
import com.bsf.Supplies.repository.PumpRepository;
import com.bsf.Supplies.repository.SupplyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class SupplyService {

    private final SupplyRepository supplyRepository;
    private final PumpRepository pumpRepository;

    public SupplyService(SupplyRepository supplyRepository, PumpRepository pumpRepository) {
        this.supplyRepository = supplyRepository;
        this.pumpRepository = pumpRepository;
    }

    @Transactional
    public SupplyDTO create(SupplyDTO supplyDTO){
        Pump pump = pumpRepository.findById(supplyDTO.pump().id()).orElseThrow(()->
                new ResourseNotFoundException("Pump not found"));

        Supply supply = SupplyMapper.toDomain(supplyDTO);

        supply.setPump(pump);

        BigDecimal totalPrice = supplyDTO.liters().multiply(pump.getFuel().getPrice());
        supply.setTotalPrice(totalPrice);

        Supply supplySaved = supplyRepository.save(supply);
        return SupplyMapper.toDTO(supplySaved);
    }
}
