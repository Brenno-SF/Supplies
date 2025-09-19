package com.bsf.Supplies.controller;

import com.bsf.Supplies.dto.FuelDTO;
import com.bsf.Supplies.dto.PumpDTO;
import com.bsf.Supplies.entity.Pump;
import com.bsf.Supplies.service.PumpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pumps")
public class PumpController {
    private final PumpService pumpService;

    public PumpController(PumpService pumpService) {
        this.pumpService = pumpService;
    }

    @PostMapping()
    public ResponseEntity<PumpDTO> create(@RequestBody PumpDTO pumpDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(pumpService.create(pumpDTO));
    }

    @GetMapping()
    public ResponseEntity<List<PumpDTO>>getAllPumps(){
        List<PumpDTO> pumps = pumpService.getAll();
        return ResponseEntity.ok(pumps);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PumpDTO>getPumpById(@PathVariable Long id){
        return ResponseEntity.ok(pumpService.getById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<PumpDTO>updatePumpById(@PathVariable Long id, @RequestBody PumpDTO pumpDTO){
        return ResponseEntity.ok(pumpService.updateById(id,pumpDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePumpById(@PathVariable Long id){
        pumpService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
