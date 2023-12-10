package com.java.healthybasket.HealthyBasket.repository;

import com.java.healthybasket.HealthyBasket.model.FruitsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FruitsDataRepository extends JpaRepository<FruitsData, Long> {

    FruitsData findByName(String name);
}
