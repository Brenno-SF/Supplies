package com.bsf.Supplies.controller;

import com.bsf.Supplies.dto.PumpDTO;
import com.bsf.Supplies.dto.SupplyDTO;
import com.bsf.Supplies.service.SupplyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplies")
public class SupplyController {
    private final SupplyService supplyService;

    public SupplyController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }

    @PostMapping()
    public ResponseEntity<SupplyDTO> create(@RequestBody SupplyDTO supplyDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(supplyService.create(supplyDTO));
    }
}
