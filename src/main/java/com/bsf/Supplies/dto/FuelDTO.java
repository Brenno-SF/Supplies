package com.bsf.Supplies.dto;

import java.math.BigDecimal;

public record FuelDTO(
    Long id,
    String name,
    BigDecimal price
) {
}
