package controllers;

import dao.CarDAO;
import dto.CarDTO;
import entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(value = "/car")
public class RESTController {

    @Autowired
    private CarDAO carDAO;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET,
                    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<Car> getCars(Model model){
        List<Car> list = carDAO.getAllCars();
        return list;
    }

    @RequestMapping(value = "/get/{id}",
                    method = RequestMethod.GET,
                    produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Car getCar(@PathVariable("id") String id){
        return carDAO.getCar(id);
    }

    @RequestMapping(value = "/delete/{id}",
                    method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Car deleteCar(@PathVariable("id")String id) throws URISyntaxException {
        return carDAO.deleteCar(id);
    }

    @RequestMapping(value = "/add",
                    method = RequestMethod.POST,
                    produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Car addCar(@ModelAttribute("car") CarDTO newCar,
                         Model model){
        return carDAO.addCar(newCar);
    }



}
