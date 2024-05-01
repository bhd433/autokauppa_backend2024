package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Auto;
import com.example.demo.domain.AutoRepository;
import com.example.demo.domain.KauppaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class CarController {
    

    @Autowired
    AutoRepository carRepository;

    @Autowired
    KauppaRepository kauppaRepository;


    // login sivu
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    

    // tervetulo sivu
    @GetMapping("/index")
    public String index() {

        return "tervetuloa";
    }
    

    // autolista
    @GetMapping("/carlist")
    public String carlist(Model model) {

        model.addAttribute("cars", carRepository.findAll());
        return "carlist";
    }


    // auton lisäys
    @GetMapping("/addcar")
    public String addcar(Model model) {

        model.addAttribute("car", new Auto());
        model.addAttribute("kaupat", kauppaRepository.findAll());
        return "carform";
    }


    // tallenna auto
    @PostMapping("/savecar")
    public String savecar(Auto car) {
        
        carRepository.save(car);
        return "redirect:carlist";
    }
    

    // poista auto
    @GetMapping("/deletecar/{id}")
    public String deletecar(@PathVariable("id") long id) {

        carRepository.deleteById(id);
        return "redirect:/carlist";
        // pitää olla "redirect:/carlist" jotta toimii,
        // sen sijaan kuin "redirect:carlist"
    }


    // muokkaa autoa
    @GetMapping("/editcar/{id}")
    public String editcar(@PathVariable("id") long id, Model model) {

        model.addAttribute("car", carRepository.findById(id));
        model.addAttribute("kaupat", kauppaRepository.findAll());
        return "carform";
    }
}
