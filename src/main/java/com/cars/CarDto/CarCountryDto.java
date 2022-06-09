package com.cars.CarDto;

import javax.validation.constraints.NotBlank;

public class CarCountryDto {

    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String model;

    private int price;

    @NotBlank
    private String countryCreator;

    private int yearCreator;

    private int continentId;

    private int idCr;

    //@NotBlank
    private String continent;

    public CarCountryDto() {
    }

    public CarCountryDto(Long id, @NotBlank String title, @NotBlank String model, int price, @NotBlank String countryCreator, int yearCreator, int continentId, int idCr, String continent) {
        this.id = id;
        this.title = title;
        this.model = model;
        this.price = price;
        this.countryCreator = countryCreator;
        this.yearCreator = yearCreator;
        this.continentId = continentId;
        this.idCr = idCr;
        this.continent = continent;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getContinentId() {
        return continentId;
    }

    public void setContinentId(int continentId) {
        this.continentId = continentId;
    }

    public int getIdCr() {
        return idCr;
    }

    public void setIdCr(int idCr) {
        this.idCr = idCr;
    }
}
