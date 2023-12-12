package com.java.healthybasket.HealthyBasket.controller;

import com.java.healthybasket.HealthyBasket.model.DailyEssentialsData;
import com.java.healthybasket.HealthyBasket.service.DailyEssentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@RequestMapping("/basket")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DailyEssentialsController {

    @Autowired
    private DailyEssentialsService dailyEssentialsService;

    @GetMapping("/getDailyEssentials")
    public ResponseEntity<List<DailyEssentialsData>> getAllDailyEssentials(String name){
        try{
            List<DailyEssentialsData> files = new ArrayList<>();
            if(name==null){
                files.addAll(dailyEssentialsService.findAll());
            } else {
                System.out.println(dailyEssentialsService.findAll());
            }
            if(files.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(files,HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getDailyEssentials/{name}")
    public DailyEssentialsData getDailyEssentials(@PathVariable("name") String name){
        DailyEssentialsData dailyEssentials = dailyEssentialsService.getDailyEssentialsByName(name);
        return dailyEssentials;
    }
    @PostMapping("/addDailyEssentials")
    public ResponseEntity<String> storeFilesIntoDb(@RequestParam("file")MultipartFile file,
                                                   @RequestParam("name") String name,
                                                   @RequestParam("slogan") String slogan,
                                                   @RequestParam("description") String description,
                                                   @RequestParam("price") Integer price,
                                                   @RequestParam("healthBenefits") String healthBenefits,
                                                   @RequestParam("weight") String weight,
                                                   @RequestParam("lifetime") String lifetime,
                                                   @RequestParam("quantity") Integer quantity,
                                                   @RequestParam("date") Date addedDate
    ) throws IOException {
        String response = dailyEssentialsService.storeImage(file,name,slogan,description,price,healthBenefits,weight,lifetime,quantity,addedDate);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @PutMapping("updateDailyEssentials/{name}")
    public ResponseEntity<DailyEssentialsData> updateUser(@PathVariable String name,
                                                 @RequestParam("file")MultipartFile file,
                                                 @RequestParam("slogan") String slogan,
                                                 @RequestParam("description") String description,
                                                 @RequestParam("price") Integer price,
                                                 @RequestParam("healthBenefits") String healthBenefits,
                                                 @RequestParam("weight") String weight,
                                                 @RequestParam("lifetime") String lifetime,
                                                 @RequestParam("quantity") Integer quantity,
                                                 @RequestParam("date") Date addedDate) throws IOException {
        DailyEssentialsData dailyEssentials = dailyEssentialsService.getDailyEssentialsByName(name);
        if (!(dailyEssentials.getName()).equals("")) {
            dailyEssentials.setName(name);
            dailyEssentials.setSlogan(slogan);
            dailyEssentials.setDescription(description);
            dailyEssentials.setPrice(price);
            dailyEssentials.setQuantity(quantity);
            dailyEssentials.setWeight(weight);
            dailyEssentials.setAddedDate(addedDate);
            dailyEssentials.setImagePath(file.getBytes());
            dailyEssentials.setHealthBenefits(healthBenefits);
            dailyEssentials.setLifetime(lifetime);
            dailyEssentialsService.save(dailyEssentials);
            return new ResponseEntity<>(dailyEssentials, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/dailyessentials/{name}")
    public ResponseEntity<String> deleteMovieById(@PathVariable("name") String name)
    {
        DailyEssentialsData dailyEssentials = dailyEssentialsService.getDailyEssentialsByName(name);
        dailyEssentialsService.delete(dailyEssentials);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
