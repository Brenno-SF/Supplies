package com.bsf.Supplies.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SupplyDTO(
        Long id,
        String name,
        LocalDateTime date,
        PumpDTO pump,
        BigDecimal liters,
        BigDecimal totalPrice

) {
}
