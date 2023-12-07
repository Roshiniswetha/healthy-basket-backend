package com.java.healthybasket.HealthyBasket.service;

import com.java.healthybasket.HealthyBasket.model.DailyEssentials;
import com.java.healthybasket.HealthyBasket.model.Vegetables;
import com.java.healthybasket.HealthyBasket.repository.DailyEssentialsRepository;
import com.java.healthybasket.HealthyBasket.repository.VegetablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DailyEssentialsDataService {

    @Autowired
    DailyEssentialsRepository dailyEssentialsRepository;

    public Optional<DailyEssentials> findById(long id){
        return dailyEssentialsRepository.findById(id);
    }

    public List<DailyEssentials> findByName(String name){
        return dailyEssentialsRepository.findByName(name);
    }

    public List<DailyEssentials> findAll() {
        return dailyEssentialsRepository.findAll();
    }

    public void deleteById(long id) {
        dailyEssentialsRepository.deleteById(id);
    }

    public DailyEssentials save(DailyEssentials dailyEssentials){
        dailyEssentialsRepository.save(dailyEssentials);
        return dailyEssentials;
    }

}
