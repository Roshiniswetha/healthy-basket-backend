package com.java.healthybasket.HealthyBasket.service;

import com.java.healthybasket.HealthyBasket.model.DailyEssentialsData;
import com.java.healthybasket.HealthyBasket.repository.DailyEssentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class DailyEssentialsService {

    @Autowired
    private DailyEssentialsRepository dailyEssentialsRepository;
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
        DailyEssentialsData image = DailyEssentialsData.builder()
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
        image = dailyEssentialsRepository.save(image);
        if(image.getImagePath() != null){
            return "Filee UPloaded";
        }
        return null;
    }

    public DailyEssentialsData getDailyEssentialsByName(String name){
        return dailyEssentialsRepository.findByName(name);
    }

    public List<DailyEssentialsData> findAll() {
        return dailyEssentialsRepository.findAll();
    }

    public DailyEssentialsData save(DailyEssentialsData dailyEssentials) {
        return dailyEssentialsRepository.save(dailyEssentials);
    }

    public void delete(DailyEssentialsData dailyEssentials) {
        dailyEssentialsRepository.delete(dailyEssentials);
    }
}
