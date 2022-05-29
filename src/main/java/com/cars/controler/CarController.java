package com.cars.controler;

import com.cars.CarDto.CarDto;
import com.cars.Service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/car")
@Controller
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String listPage(Model model) {
        model.addAttribute("cars", carService.findAll());
        return "car";
    }

    @GetMapping("/sortMin/{number}")
    public String findAllSortMin(@PathVariable("number") int number, Model model) {
        model.addAttribute("cars", carService.findAllMinPrice(number));
        return "redirect:/car";
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

}
