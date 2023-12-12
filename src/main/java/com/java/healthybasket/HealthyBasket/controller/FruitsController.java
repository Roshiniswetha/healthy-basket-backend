package com.java.healthybasket.HealthyBasket.controller;

//import com.java.healthybasket.HealthyBasket.model.CategoryData;
import com.java.healthybasket.HealthyBasket.model.FruitsData;
import com.java.healthybasket.HealthyBasket.service.FruitsService;
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
public class FruitsController {

    @Autowired
    private FruitsService fruitsDataService;

    @GetMapping("/getFruits")
    public ResponseEntity<List<FruitsData>> getAllFruits(String name){
        try{
            List<FruitsData> files = new ArrayList<>();
            if(name==null){
                files.addAll(fruitsDataService.findAll());
            } else {
                System.out.println(fruitsDataService.findAll());
            }
            if(files.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(files,HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getFruitsByCategory")
    public ResponseEntity<HashMap<String,List<FruitsData>>> getFruitsByCategory() {
//        Optional<CategoryData> category = categoryRepository.findByName(categoryName);
        try {
            List<FruitsData> fruits = fruitsDataService.findAll();

            if (fruits.size() > 0) {
                HashMap<String, List<FruitsData>> fruitsByCategory = new HashMap<>();
//            List<FruitsData> fruitsListByCategory = new ArrayList<>();
                for (FruitsData singleFruit : fruits) {
                    if (fruitsByCategory.containsKey(singleFruit.getCategory())) {
//                        List<FruitsData> fruitsListByCategory = fruitsByCategory.get(singleFruit.getCategory());
//                        fruitsListByCategory.add(singleFruit);
                        fruitsByCategory.get(singleFruit.getCategory()).add(singleFruit);
//                        fruitsByCategory.put(singleFruit.getCategory(), fruitsListByCategory);
                    } else {
                        System.out.println(singleFruit.getCategory());
                        fruitsByCategory.put(singleFruit.getCategory(), new ArrayList<FruitsData>(Collections.singleton(singleFruit)));
                    }
                }
                return new ResponseEntity<>(fruitsByCategory, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/getFruits/{name}")
    public FruitsData getFruit(@PathVariable("name") String name){
        FruitsData fruit = fruitsDataService.getFruitByName(name);
        return fruit;
//        if (fruitsData.isPresent()) {
//            return fruitsData.map(FruitsData::getImagePath);
//        } else {
//            return null;
//        }
    }
    @PostMapping("/addFruits")
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
        String response = fruitsDataService.storeImage(file,name,slogan,description,price,healthBenefits,weight,lifetime,quantity,addedDate);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @PutMapping("updateFruit/{name}")
    public ResponseEntity<FruitsData> updateUser(@PathVariable String name,
                                                 @RequestParam("file")MultipartFile file,
                                                 @RequestParam("slogan") String slogan,
                                                 @RequestParam("description") String description,
                                                 @RequestParam("price") Integer price,
                                                 @RequestParam("healthBenefits") String healthBenefits,
                                                 @RequestParam("weight") String weight,
                                                 @RequestParam("lifetime") String lifetime,
                                                 @RequestParam("quantity") Integer quantity,
                                                 @RequestParam("date") Date addedDate) throws IOException {
        FruitsData fruits = fruitsDataService.getFruitByName(name);
        if (!(fruits.getName()).equals("")) {
//            FruitsData existingFruit = fruits.get(name);
            fruits.setName(name);
            fruits.setSlogan(slogan);
            fruits.setDescription(description);
            fruits.setPrice(price);
            fruits.setQuantity(quantity);
            fruits.setWeight(weight);
//            fruits.setContentType(fruitsDetails.getContentType());
            fruits.setAddedDate(addedDate);
            fruits.setImagePath(file.getBytes());
            fruits.setHealthBenefits(healthBenefits);
            fruits.setLifetime(lifetime);
            fruitsDataService.save(fruits);
            return new ResponseEntity<>(fruits, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/fruits/{name}")
    public ResponseEntity<String> deleteMovieById(@PathVariable("name") String name)
    {
        FruitsData fruit = fruitsDataService.getFruitByName(name);
        fruitsDataService.delete(fruit);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
