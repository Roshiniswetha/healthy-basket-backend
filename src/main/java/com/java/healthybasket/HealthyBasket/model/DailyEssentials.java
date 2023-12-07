package com.java.healthybasket.HealthyBasket.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="dailyessentials")
public class DailyEssentials {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="slogan")
    private String slogan;

    @Column(name="description")
    private String description;

    @Column(name="quantity")
    private int quantity;

    @Column(name="price")
    private int price;

    @Column(name="weight")
    private String weight;

    @Column(name="lifetime")
    private String lifetime;

    @Column(name="healthBenefits")
    private String healthBenefits;

    @Column(name="type")
    private String type;

    @Lob
    @Column(name="image", length = 1000)
    private byte[] image;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name="addedDate")
    private Date date;

    public DailyEssentials(String name,
                      String slogan,
                      String description,
                      int quantity,
                      int price,
                      String weight,
                      String lifetime,
                      String healthBenefits,
                      String type,
                      byte[] image,
                      Date date){
        this.name = name;
        this.slogan = slogan;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.weight = weight;
        this.lifetime = lifetime;
        this.healthBenefits = healthBenefits;
        this.image = image;
        this.date = date;
        this.type = type;
    }

    public DailyEssentials() {

    }

    public void setImage(byte[] image){
        this.image = image;
    }

    public byte[] getImage(){
        return image;
    }

    public long getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setSlogan(String slogan){
        this.slogan = slogan;
    }

    public String getSlogan(){
        return slogan;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    public void setWeight(String weight){
        this.weight = weight;
    }

    public String getWeight(){
        return weight;
    }

    public void setLifetime(String lifetime){
        this.lifetime = lifetime;
    }

    public String getLifetime(){
        return lifetime;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }

    public void setHealthBenefits(String healthBenefits){
        this.healthBenefits = healthBenefits;
    }

    public String getHealthBenefits(){
        return healthBenefits;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public Date getDate(){
        return date;
    }

    @Override
    public String toString(){
        return "Fruits [id=" + id + ", name=" + name + ", slogan=" + slogan + ", desc=" + description + ", price=" + price + ", weight=" + weight + ", quantity=" + quantity + ", lifetime=" + lifetime + ", healthBenefits=" + healthBenefits + ", type=" + type + ", date=" + date + "]";
    }

}
