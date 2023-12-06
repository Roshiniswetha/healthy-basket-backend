package com.java.healthybasket.HealthyBasket.service;

import com.java.healthybasket.HealthyBasket.model.Fruits;
import com.java.healthybasket.HealthyBasket.repository.FruitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitsDataService {

    @Autowired
    FruitsRepository fruitsRepository;

    public Optional<Fruits> findById(long id){
        return fruitsRepository.findById(id);
    }

    public List<Fruits> findByName(String name){
        return fruitsRepository.findByName(name);
    }

    public List<Fruits> findAll() {
        return fruitsRepository.findAll();
    }

    public void deleteById(long id) {
        fruitsRepository.deleteById(id);
    }

    public Fruits save(Fruits fruit){
        fruitsRepository.save(fruit);
        return fruit;
    }

}
