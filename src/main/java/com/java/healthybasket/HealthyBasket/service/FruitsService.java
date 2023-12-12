package com.java.healthybasket.HealthyBasket.service;

import com.java.healthybasket.HealthyBasket.model.FruitsData;
import com.java.healthybasket.HealthyBasket.repository.FruitsDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FruitsService {

    @Autowired
    private FruitsDataRepository fruitsDataRepository;
    public String storeImage(MultipartFile file,
                             String name,
                             String slogan,
                             String description,
                             Integer price,
                             String healthBenefits,
                             String weight,
                             String lifetime,
                             Integer quantity,
                             Date addedData
                             ) throws IOException {
        FruitsData image = FruitsData.builder()
                .name(name)
                .type(file.getContentType())
                .slogan(slogan)
                .price(price)
                .healthBenefits(healthBenefits)
                .weight(weight)
                .lifetime(lifetime)
                .quantity(quantity)
                .description(description)
                .addedDate(addedData)
                .imagePath(file.getBytes()).build();
        image = fruitsDataRepository.save(image);
        if(image.getImagePath() != null){
            return "Filee UPloaded";
        }
        return null;
    }

    public FruitsData getFruitByName(String name){
        return fruitsDataRepository.findByName(name);
    }

//    public List<FruitsData> getFruitsByCategory(String category){return fruitsDataRepository.findByCategory(category);}

    public List<FruitsData> findAll() {
        return fruitsDataRepository.findAll();
    }

    public FruitsData save(FruitsData fruits) {
        return fruitsDataRepository.save(fruits);
    }

    public void delete(FruitsData fruit) {
        fruitsDataRepository.delete(fruit);
    }
}
