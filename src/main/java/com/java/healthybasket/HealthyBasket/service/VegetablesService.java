package com.java.healthybasket.HealthyBasket.service;

import com.java.healthybasket.HealthyBasket.model.VegetablesData;
import com.java.healthybasket.HealthyBasket.repository.VegetablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class VegetablesService {

    @Autowired
    private VegetablesRepository vegetablesRepository;
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
        VegetablesData image = VegetablesData.builder()
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
        image = vegetablesRepository.save(image);
        if(image.getImagePath() != null){
            return "Filee UPloaded";
        }
        return null;
    }

    public VegetablesData getVegetableByName(String name){
        return vegetablesRepository.findByName(name);
    }

    public List<VegetablesData> findAll() {
        return vegetablesRepository.findAll();
    }

    public VegetablesData save(VegetablesData vegetable) {
        return vegetablesRepository.save(vegetable);
    }

    public void delete(VegetablesData vegetable) {
        vegetablesRepository.delete(vegetable);
    }
}
