package com.java.healthybasket.HealthyBasket.repository;

import com.java.healthybasket.HealthyBasket.model.DailyEssentialsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DailyEssentialsRepository extends JpaRepository<DailyEssentialsData, Long> {
    DailyEssentialsData findByName(String name);
    Optional<DailyEssentialsData> findById(Long id);
}
