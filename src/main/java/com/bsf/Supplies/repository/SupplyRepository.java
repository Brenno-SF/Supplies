package com.bsf.Supplies.repository;

import com.bsf.Supplies.entity.Supply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplyRepository extends JpaRepository<Supply, Long> {
}
