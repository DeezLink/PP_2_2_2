package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;
import web.service.CarServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping("/cars")
public class CarController {
    private CarService carService;
    @Autowired
    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }
    @GetMapping
    public String getCarCount(@RequestParam(value = "count") Optional<Integer> count, Model model) {
        if (count == null) {
            model.addAttribute("carCount", carService.getCars());
        } else {
            model.addAttribute("carCount", carService.getCarCount(count.orElse(0)));
        }
        return "cars";
    }
}
