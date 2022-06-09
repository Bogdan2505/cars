package com.cars.persist;

import javax.persistence.*;

@Entity
@Table(name = "carsCountry")
public class CarCountry {

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

    private int continentId;

    private int crId;

   // @Column(nullable = false)
    private String continent;



    public CarCountry() {
    }

    public CarCountry(Long id, String title, String model, int price, String countryCreator, int yearCreator, int continentId, int crId, String continent) {
        this.id = id;
        this.title = title;
        this.model = model;
        this.price = price;
        this.countryCreator = countryCreator;
        this.yearCreator = yearCreator;
        this.continentId = continentId;
        this.crId = crId;
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

    public int getCrId() {
        return crId;
    }

    public void setCrId(int crId) {
        this.crId = crId;
    }
}
