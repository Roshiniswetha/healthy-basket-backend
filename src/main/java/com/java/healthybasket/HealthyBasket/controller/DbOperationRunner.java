//package com.java.healthybasket.HealthyBasket.controller;
//
//import com.java.healthybasket.HealthyBasket.model.Fruits;
//import com.java.healthybasket.HealthyBasket.repository.FruitsRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.util.Arrays;
//import java.util.Date;
//
//@Component
//public class DbOperationRunner implements CommandLineRunner {
//
//    @Autowired
//    private FruitsRepository fruitsRepository;
//
////    private final String imageFile = "C:\\Users\\Admin\\dev\\images\\apple.avif";
//
//    @Override
//    public void run(String... args) throws Exception {
//        Fruits fruit = new Fruits();
//        fruit.setName("Apple");
//        fruit.setDescription("Sweet, crispy fruit with red-orange skin and yellow undertones giving it a regal look");
//        fruit.setSlogan("Everyday Essential Fuel");
//        fruit.setQuantity(200);
//        fruit.setPrice(85);
//        fruit.setWeight("250-400g");
//        fruit.setHealthBenefits("High in fibre & vitamin C and improves immune system & helps in digestion");
//        fruit.setLifetime("10days");
//        fruit.setDate(new Date(4/12/2023));
//
//        File image = new File("C:\\Users\\Admin\\dev\\images\\apple.avif");
//        byte[] bFile = new byte[(int)image.length()];
//        try{
//            FileInputStream fileInputStream = new FileInputStream(image);
//            fileInputStream.read(bFile);
//            fileInputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        fruit.setImage(bFile);
//
//        fruitsRepository.save(fruit);
//    }
//}
