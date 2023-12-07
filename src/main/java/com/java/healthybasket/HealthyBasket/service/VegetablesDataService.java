package com.java.healthybasket.HealthyBasket.service;

import com.java.healthybasket.HealthyBasket.model.Vegetables;
import com.java.healthybasket.HealthyBasket.repository.VegetablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetablesDataService {

    @Autowired
    VegetablesRepository vegetablesRepository;

    public Optional<Vegetables> findById(long id){
        return vegetablesRepository.findById(id);
    }

    public List<Vegetables> findByName(String name){
        return vegetablesRepository.findByName(name);
    }

    public List<Vegetables> findAll() {
        return vegetablesRepository.findAll();
    }

    public void deleteById(long id) {
        vegetablesRepository.deleteById(id);
    }

    public Vegetables save(Vegetables vegetables){
        vegetablesRepository.save(vegetables);
        return vegetables;
    }

}
