package com.java.healthybasket.HealthyBasket.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "vegetables")
public class VegetablesData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    private String contentType;

    private String slogan;

    private String description;

    private Integer price;

    private Integer quantity;

    private String weight;

    private String healthBenefits;

    private String lifetime;

    private Date addedDate;

    @Lob
    private byte[] imagePath;

//    @ManyToOne
//    @JoinColumn(name = "category")
//    private CategoryData category;
}
