package com.java.healthybasket.HealthyBasket.repository;

import com.java.healthybasket.HealthyBasket.model.VegetablesData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VegetablesRepository extends JpaRepository<VegetablesData, Long> {

    VegetablesData findByName(String name);
}
