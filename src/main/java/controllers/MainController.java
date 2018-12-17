package controllers;

import dto.CarDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = "/")
    public String main (Model model){
        CarDTO car = new CarDTO();
        model.addAttribute("newCar", car);
        return "index";
    }
}
