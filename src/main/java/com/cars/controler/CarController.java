package com.cars.controler;

import com.cars.CarDto.CarDto;
import com.cars.Service.CarCountryService;
import com.cars.Service.CarService;
import com.cars.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/car")
@Controller
public class CarController {

    private final CarService carService;
    private final CountryService countryService;
    private final CarCountryService carCountryService;


    public CarController(CarService carService, CountryService countryService, CarCountryService carCountryService) {
        this.carService = carService;
        this.countryService = countryService;
        this.carCountryService = carCountryService;
    }

    @GetMapping
    public String listPage(Model model) {
        model.addAttribute("cars", carService.findAll());
        return "car";
    }


    @GetMapping("/{id}")
    public String form(@PathVariable("id") long id, Model model) {
        model.addAttribute("car", carService.findById(id));
        return "car_form";
    }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("car", new CarDto());
        // model.addAttribute("country", new CountryCreator());

        return "car_form";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute("car") CarDto carDto, BindingResult binding) {
        if (binding.hasErrors()) {
            return "car_form";
        }
        carService.save(carDto);
        return "redirect:/car";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        carService.deleteById(id);
        return "redirect:/car";
    }

    private int numberMin = 0;

    @PostMapping("/sortMin")
    public String sortMinBound(@RequestParam("number") int number) {
        this.numberMin = number;
        return "redirect:/car";
        // return "redirect:/car";
    }

    @GetMapping("/sortMin")
    public String findAllSortMinBound(Model model) {
        if (numberMin != 0) {
            model.addAttribute("cars", carService.findAllMinBoundPrice(numberMin));
            return "filter";
        }
        return "car";
    }

    private int numberMax = 0;

    @PostMapping("/sortMax")
    public String sortMaxBound(@RequestParam("number") int number) {
        this.numberMax = number;
        return "redirect:/car";
        // return "redirect:/car";
    }

    @GetMapping("/sortMax")
    public String findAllSortMaxBound(Model model) {
        if (numberMax != 0) {
            model.addAttribute("cars", carService.findAllMaxBoundPrice(numberMax));
            return "filter";
        }
        return "car";
    }

    private int numberEquals = 0;

    @PostMapping("/sortEquals")
    public String sortEquals(@RequestParam("number") int number) {
        this.numberEquals = number;
        return "redirect:/car";
        // return "redirect:/car";
    }

    @GetMapping("/sortEquals")
    public String findAllSortEquals(Model model) {
        if (numberEquals != 0) {
            model.addAttribute("cars", carService.findAllEqualsPrice(numberEquals));
            return "filter";
        }
        return "car";
    }

    @GetMapping("/between")
    public String findAllBetween(Model model) {
        if (numberMin != 0 || numberMax != 0) {
            model.addAttribute("cars", carService.findAllBetween(numberMin, numberMax));
            return "filter";
        }
        return "car";
    }

    @GetMapping("/sortDesc")
    public String findAllSortDesc(Model model) {
        model.addAttribute("cars", carService.findAllSortDesc());
        return "filter";
    }

    @GetMapping("/groupBy")
    public String findAllGroupBy(Model model) {
        model.addAttribute("cars", carService.findAllGroupBy());
        return "groupBy";
    }


    @GetMapping("/innerJoin")
    public String innerJoin(Model model) {
        model.addAttribute("carsCountry", carCountryService.innerJoin());
        return "innerJoin";
    }
}



