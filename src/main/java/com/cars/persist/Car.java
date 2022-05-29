package com.cars.persist;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cars")
       /* indexes = {
                @Index(name = "ux_car", columnList = "country_id", unique = true)
        })*/
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, unique = true)
    private String model;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String countryCreator;

    @Column(nullable = false)
    private int yearCreator;



    public Car() {
    }


    public Car(Long id, String title, String model, int price, String countryCreator, int yearCreator) {
        this.id = id;
        this.title = title;
        this.model = model;
        this.price = price;
        this.countryCreator = countryCreator;
        this.yearCreator = yearCreator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCountryCreator() {
        return countryCreator;
    }

    public void setCountryCreator(String countryCreator) {
        this.countryCreator = countryCreator;
    }

    public int getYearCreator() {
        return yearCreator;
    }

    public void setYearCreator(int yearCreator) {
        this.yearCreator = yearCreator;
    }
}
