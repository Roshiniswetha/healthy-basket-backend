package com.java.healthybasket.HealthyBasket.controller;

import com.java.healthybasket.HealthyBasket.model.DailyEssentials;
//import com.java.healthybasket.HealthyBasket.model.Fruits;
import com.java.healthybasket.HealthyBasket.model.Vegetables;
//import com.java.healthybasket.HealthyBasket.repository.FruitsRepository;
import com.java.healthybasket.HealthyBasket.service.DailyEssentialsDataService;
//import com.java.healthybasket.HealthyBasket.service.FruitsDataService;
import com.java.healthybasket.HealthyBasket.service.VegetablesDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/basket")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DailyEssentialsController {

    @Autowired
    DailyEssentialsDataService dailyEssentialsDataService;

    @GetMapping("/dailyessentials")
    public ResponseEntity<List<DailyEssentials>> getAllDailyEssentials(String name){
        try{
            List<DailyEssentials> dailyEssentials = new ArrayList<>();
            if(name==null){
                dailyEssentials.addAll(dailyEssentialsDataService.findAll());
            } else {
                dailyEssentials.addAll(dailyEssentialsDataService.findByName(name));
            }
            if(dailyEssentials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(dailyEssentials,HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//
//    @GetMapping("/fruits/{id}")
//    public ResponseEntity<Fruits> getFruitById(@PathVariable("id") long id){
//        Optional<Fruits> optional = fruitsDataService.findById(id);
//        return optional.map(fruits -> new ResponseEntity<>(fruits, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    @PostMapping("/fruits")
//    public ResponseEntity<Fruits> createFruits(@RequestBody Fruits newfruit){
//        fruitsDataService.save(newfruit);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

//    @PutMapping("/fruits/{id}")
//    public Fruits updateFruits(@PathVariable("id") long id, @RequestBody Fruits fruit){
//        return fruitsDataService.findById(id)
//                .map(fruits->{
//                    fruits.setName(fruit.getName());
//                    fruits.setSlogan(fruit.getSlogan());
//                    fruits.setDescription(fruit.getDescription());
//                    fruits.setQuantity(fruit.getQuantity());
//                    fruits.setPrice(fruit.getPrice());
//                    fruits.setWeight(fruit.getWeight());
//                    fruits.setLifetime(fruit.getLifetime());
//                    fruits.setHealthBenefits(fruit.getHealthBenefits());
//                    fruits.setImage(fruit.getImage());
//                    fruits.setDate(fruit.getDate());
//                    return fruitsDataService.save(fruits);
//                })
//                .orElseGet(()->{
//                    return  fruitsDataService.save(fruit);
//                });
//    }

//    @DeleteMapping("/fruits/all")
//    public void removeAllFruits(@PathVariable("id") Long id){
//        fruitsRepository.deleteById(id);
//    }

//    @DeleteMapping("/fruits/{id}")
//    public ResponseEntity<Fruits> removeFruitsById(@PathVariable("id") long id){
//        Optional<Fruits> optional = fruitsDataService.findById(id);
//        if(optional.isPresent()){
//            fruitsDataService.deleteById(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
