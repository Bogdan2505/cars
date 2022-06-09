package com.cars.CarDto;

import javax.validation.constraints.NotBlank;

public class CountryDto {

    private Long id;

    @NotBlank
    private String title;

    public CountryDto() {
    }

    public CountryDto(Long id, @NotBlank String title) {
        this.id = id;
        this.title = title;
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
}
