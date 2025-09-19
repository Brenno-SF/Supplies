package com.bsf.Supplies.controller;

import com.bsf.Supplies.dto.FuelDTO;
import com.bsf.Supplies.service.FuelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fuels")
public class FuelController {
    private final FuelService fuelService;

    public FuelController(FuelService fuelService) {
        this.fuelService = fuelService;
    }

    @PostMapping()
    public ResponseEntity<FuelDTO>createFuel(@RequestBody FuelDTO fuelDTO){
        FuelDTO fuelCreated = fuelService.create(fuelDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(fuelCreated);
    }

    @GetMapping()
    public ResponseEntity<List<FuelDTO>>getAllFuels(){
        List<FuelDTO> fuels = fuelService.getAll();
        return ResponseEntity.ok(fuels);
    }
    @GetMapping("/{id}")
    public ResponseEntity<FuelDTO>getFuelById(@PathVariable Long id){
        return ResponseEntity.ok(fuelService.getById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<FuelDTO>update(@PathVariable Long id, @RequestBody FuelDTO fuelDTO){
        return ResponseEntity.ok(fuelService.update(id, fuelDTO));
    }
}
