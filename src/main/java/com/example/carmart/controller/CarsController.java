package com.example.carmart.controller;

import com.example.carmart.models.Cars;
import com.example.carmart.repository.CarsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class CarsController {

    @Autowired
    private CarsRepository carsRepository;

    @GetMapping("/customer_login")
    public String customerLogin() {
        return "customer_login";
    }

    @GetMapping("/admin_login")
    public String adminLogin() {
        return "admin_login";
    }

    @PostMapping("/customer_login")
    public String customerLoggedIn() {
        return "customer_homepage";
    }

    @PostMapping("/admin_login")
    public String adminLoggedIn(@RequestParam("username") String userName,
                                @RequestParam("password") String password) {

        if ("stella@gmail.com".equals(userName) && "admin".equals(password)) {
            return "admin_homepage";
        } else {
            return "check_credential";
        }
    }


    @GetMapping("/admin_homepage")
    public String adminHomepage() {
        return "admin_homepage";
    }

    @GetMapping("/check_credential")
    public String checkCredential() {
        return "check_credential";
    }

    @GetMapping("/customer_homepage")
    public String customerHomepage() {
        return "customer_homepage";
    }

    @GetMapping("/carmart_brand")
    public String carmartBrand(Model model) {
        List<String> carBrands = carsRepository.findAllBrands();
        model.addAttribute("brands", carBrands);
        return "carmart_brand";
    }

    @GetMapping("/carmart_price")
    public String carmartPrice() {
        return "carmart_price";
    }

    @PostMapping("/findmodels")
    public String findModels(@RequestParam String brand, Model model) {
        // Fetch all cars based on the selected brand
        List<Cars> carList = carsRepository.findCarsByBrand(brand);

        // Add the list of cars to the model
        model.addAttribute("carList", carList);
        String backbutton ="/carmart_brand";
        model.addAttribute("backbutton",backbutton);

        return "findmodels";
    }

    @PostMapping("/bookcar")
    public String bookcarSuccess(@RequestParam String brand, String model,Model m) {
        m.addAttribute("carName", brand);
        m.addAttribute("carModel", model);
        return "bookcar";
    }

    @PostMapping("/findprice")
    public String findModelsByPrice(@RequestParam String priceRangeHidden,
                                    Model model) {
        int price = 500000;
        if ("greater".equals(priceRangeHidden)) {
            List<Cars> carList = carsRepository.findByPriceGreaterThan(price);
            model.addAttribute("carList", carList);
        }else{
            List<Cars> carList = carsRepository.findByPriceLessThan(price);
            model.addAttribute("carList", carList);
        }
        String backbutton ="/carmart_price";
        model.addAttribute("backbutton",backbutton);
        return "findmodels";
    }

    @GetMapping("/addcar")
    public String addCar(Model model) {
        return "addcar";
    }

    @PostMapping("/addcar")
    public String addCar(@ModelAttribute("car") @Valid Cars car, BindingResult result) {
        if (result.hasErrors()) {
            // Handle validation errors
            return "addcar"; // Return to the form page to show errors
        }
        carsRepository.save(car);
        return "caradded";
    }

    @GetMapping("/caradded")
    public String caradded() {
        return "caradded";
    }

    @GetMapping("/modifycar")
    public String modifycar() {
        return "modifycar";
    }
}
