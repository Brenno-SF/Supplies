package com.bsf.Supplies.dto;

import java.math.BigDecimal;
import java.util.List;

public record FuelDTO(
    Long id,
    String name,
    BigDecimal price

) {
}
