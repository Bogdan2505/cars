package com.cars.CarDto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class CarDto {

    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String model;

    private int price;

    @NotBlank
    private String countryCreator;

    private int yearCreator;

    public CarDto() {
    }


    public CarDto(Long id, String title, String model, int price, String countryCreator, int yearCreator) {
        this.id = id;
        this.title = title;
        this.model = model;
        this.price = price;
        this.countryCreator = countryCreator;
        this.yearCreator = yearCreator;
    }


    public CarDto(String title, int price) {
        this.title = title;
        this.price = price;
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
