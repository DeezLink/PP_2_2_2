package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.CarService;
import web.service.CarServiceImpl;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cars")
public class CarController {
    private CarService carService;
    @Autowired
    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }
    @GetMapping
    public String getCarCount(HttpServletRequest request, Model model) {
        if (request.getParameter("count")==null) {
            model.addAttribute("carCount", carService.getCars());
        } else {
            model.addAttribute("carCount", carService.getCarCount(Integer.parseInt(request.getParameter("count"))));
        }
        return "cars";
    }
}
