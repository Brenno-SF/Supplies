package com.bsf.Supplies.entity;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_supply")
public class Supply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supply_id")
    private Long id;

    private String name;

    @Column(name = "liter")
    private BigDecimal liters;
    @Column(name = "total")
    private BigDecimal totalPrice;

    @CreationTimestamp
    @Column(name = "date_supply")
    private LocalDateTime date;
}
