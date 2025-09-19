package com.bsf.Supplies.controller;

import com.bsf.Supplies.dto.FuelDTO;
import com.bsf.Supplies.service.FuelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fuels")
public class FuelController {
    private final FuelService fuelService;

    public FuelController(FuelService fuelService) {
        this.fuelService = fuelService;
    }

    @PostMapping()
    public ResponseEntity<FuelDTO>createFuel(@RequestBody FuelDTO fuelDTO){
        FuelDTO fuelCreated = fuelService.createFuel(fuelDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(fuelCreated);
    }
}
