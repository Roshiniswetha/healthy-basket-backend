package com.java.healthybasket.HealthyBasket.controller;

import com.java.healthybasket.HealthyBasket.model.VegetablesData;
import com.java.healthybasket.HealthyBasket.service.VegetablesService;
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
public class VegetablesController {

    @Autowired
    private VegetablesService vegetablesDataService;

    @GetMapping("/getVegetables")
    public ResponseEntity<List<VegetablesData>> getAllVegetables(String name){
        try{
            List<VegetablesData> files = new ArrayList<>();
            if(name==null){
                files.addAll(vegetablesDataService.findAll());
            } else {
                System.out.println(vegetablesDataService.findAll());
            }
            if(files.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(files,HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getVegetables/{name}")
    public VegetablesData getVegetable(@PathVariable("name") String name){
        VegetablesData vegetable = vegetablesDataService.getVegetableByName(name);
        return vegetable;
//        if (fruitsData.isPresent()) {
//            return fruitsData.map(FruitsData::getImagePath);
//        } else {
//            return null;
//        }
    }
    @PostMapping("/addVegetable")
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
        String response = vegetablesDataService.storeImage(file,name,slogan,description,price,healthBenefits,weight,lifetime,quantity,addedDate);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @PutMapping("updateVegetable/{name}")
    public ResponseEntity<VegetablesData> updateUser(@PathVariable String name,
                                                 @RequestParam("file")MultipartFile file,
                                                 @RequestParam("slogan") String slogan,
                                                 @RequestParam("description") String description,
                                                 @RequestParam("price") Integer price,
                                                 @RequestParam("healthBenefits") String healthBenefits,
                                                 @RequestParam("weight") String weight,
                                                 @RequestParam("lifetime") String lifetime,
                                                 @RequestParam("quantity") Integer quantity,
                                                 @RequestParam("date") Date addedDate) throws IOException {
        VegetablesData vegetables = vegetablesDataService.getVegetableByName(name);
        if (!(vegetables.getName()).equals("")) {
            vegetables.setName(name);
            vegetables.setSlogan(slogan);
            vegetables.setDescription(description);
            vegetables.setPrice(price);
            vegetables.setQuantity(quantity);
            vegetables.setWeight(weight);
            vegetables.setAddedDate(addedDate);
            vegetables.setImagePath(file.getBytes());
            vegetables.setHealthBenefits(healthBenefits);
            vegetables.setLifetime(lifetime);
            vegetablesDataService.save(vegetables);
            return new ResponseEntity<>(vegetables, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/vegetables/{name}")
    public ResponseEntity<String> deleteMovieById(@PathVariable("name") String name)
    {
        VegetablesData vegetable = vegetablesDataService.getVegetableByName(name);
        vegetablesDataService.delete(vegetable);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
